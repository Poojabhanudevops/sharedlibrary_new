package org.Common

def call(String branch_name, String repo_url, String git_password) {

stage('Clone Repo') {
        checkout([$class: 'GitSCM',
                    branches: [[name: "*/${branch_name}"]],
                    userRemoteConfigs: [[url: repo_url , credentialsId: git_password ]]
                    ])
          }

}
