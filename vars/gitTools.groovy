def checkOut() {
    echo "checking in checkout(git) method"
    checkout([$class: 'GitSCM', 
             branches: [[name: params.branchName]], 
			 doGenerateSubmoduleConfigurations: false, 
			 extensions: [], 
			 submoduleCfg: [],
userRemoteConfigs: [[url: 'https://github.com/manidhar1986/jenkins-test']]])
}
