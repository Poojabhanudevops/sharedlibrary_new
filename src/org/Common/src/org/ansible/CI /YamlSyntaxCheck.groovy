package org.ansible.CI  

def call (String playbook_path) {
  stage('YAML Syntax Check') {
              script {
                  catchError(buildResult: 'SUCCESS') {
                      sh "yamllint ${playbook_path} > Report-yamllint.txt"
              }
          }
      }
  }
