node{

	def config = new CIConfig().getConfig();
	properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')), parameters([string(defaultValue: '', description: '', name: 'branchName', trim: false)]), pipelineTriggers([pollSCM('* * 1 1 *')])])
	stage('checkout'){
	checkoutCode(config);
	}
	echo "this is a string ${params.branchName}";
}
def checkoutCode(config) {
	gitTools.checkOut(URL: "${config.gitURL}", jenkinsCredentialsID: "${config.jenkinsCredentialsID}")
}