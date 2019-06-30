node{

	def config = new OSBCIConfig().getConfig();
	
	stage('checkout')
	checkoutCode(config);
	echo "this is a string ${config.gitURL}";
}
def checkoutCode(config) {
	
}

