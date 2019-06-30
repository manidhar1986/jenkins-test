node{

	def config = new OSBCIConfig().getConfig();
	
	s//tage('checkout')
	//checkoutCode(config);
	echo "this is a string ${params.branchName}";
}
//def checkoutCode(config) {
	
//}

