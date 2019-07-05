node{
	def config = new CIConfig().getConfig();
	properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')), parameters([string(defaultValue: '', description: '', name: 'branchName', trim: false)]), pipelineTriggers([pollSCM('* * 1 1 *')])])
	stage('checkout'){
		echo "params:::::::::::::::::: ${config}";
		echo "params-------------------->>>> ${params}";
	checkoutCode(config);
	}
	
}
def checkoutCode(config) {
	echo "In module1.groovy"
	echo "${config.gitURL}"
	echo"hi"
	gitTools.checkOut(URL: "${config.gitURL}");
}
