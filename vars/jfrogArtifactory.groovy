def uploadCode() {

	def server = Artifactory.server('jartifact')
	echo "val of {server}"
	
    def uploadSpec = """{
      "files": [
        {
          "pattern": "vars/CIConfig*",
	  "target": "jenkins-integration"
        }
     ]
    }"""	
		server.upload spec: uploadSpec
}
