node{

	def config = new OSBCIConfig().getConfig();
	
	echo "this is a string ${params.config}";
}
