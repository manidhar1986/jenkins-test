def uploadCode() {

	def server = Artifactory.server 'jartifact-id'
	server credentialsId = 'jfrogid'
	server bypassProxy = true
	
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
