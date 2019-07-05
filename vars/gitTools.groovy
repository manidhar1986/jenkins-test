def checkOut(params) {
    echo "checking"
    checkout([$class: 'GitSCM', 
             branches: [[name: params.branchName]], 
			 doGenerateSubmoduleConfigurations: false, 
			 extensions: [], 
			 submoduleCfg: [],
userRemoteConfigs: [[url: 'https://github.com/manidhar1986/jenkins-test']]])
}
