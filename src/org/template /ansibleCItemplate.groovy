package org.template

import org.ansible.CI.*
import org.Common.*

def call (String branch_name, String repo_url, String git_password, String playbook_path, String inventory_path, String key_path, String user_name) {

  clone = new CloneRepo()
  yamllint = new YamlSyntaxCheck()
  ansiblelint = new AnsibleLint()
  securitycheck = new SecurityCheck()
  dryrun = new DryRun()

  clone.call(branch_name, repo_url, git_password)
  yamllint.call(playbook_path)
  ansiblelint.call(playbook_path)
  securitycheck.call(playbook_path)
  dryrun.call(inventory_path, playbook_path, key_path, user_name)
  
}
