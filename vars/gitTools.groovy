def checkOut(gitconfig) {
	echo "checking {gitconfig}"
    checkout([$class: 'GitSCM', 
             branches: [[name: params.branchName]], 
			 doGenerateSubmoduleConfigurations: false, 
			 extensions: [], 
			 submoduleCfg: [],
userRemoteConfigs: [[
credentialsID:
url: gitconfig.gitURL]]])
}
