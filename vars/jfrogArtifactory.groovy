def uploadCode() {

	def server = Artifactory.server('jartifact')
	server credentialsId = 'jfrogid'
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
