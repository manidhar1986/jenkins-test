def uploadCode() {

	def server = Artifactory.server 'jartifact-id', credentialsId: 'jfrogid', bypassProxy = true
	
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
