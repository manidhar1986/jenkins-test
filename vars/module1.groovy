node{

	def config = new OSBCIConfig().getConfig();
	
	//stage('checkout')
	//checkoutCode(config);
	echo "this is a string ${params.branchName}";
}
//def checkoutCode(config) {
	
//}

