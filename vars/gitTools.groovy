def checkOut() {
    echo "checking"
    checkout([$class: 'GitSCM', 
             branches: [[name: params.branchName]], 
			 doGenerateSubmoduleConfigurations: false, 
			 extensions: [], 
			 submoduleCfg: [],
userRemoteConfigs: [[
credentialsID:
url: 'https://github.com/manidhar1986/jenkins-test']]])