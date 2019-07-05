def uploadCode() {

	def server = Artifactory.server 'jartifact-id', credentialsId: 'jfrogid', bypassProxy = true
	echo "val of {server}"
	
    def uploadSpec = """{
      "files": [
        {
          "pattern": "vars/*",
	  "target": "jenkins-integration"
        }
     ]
    }"""	
		server.upload spec: uploadSpec
}
