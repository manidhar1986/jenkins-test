def uploadCode() {

	def server = Artifactory.newServer url: 'https://myjfrogtest.jfrog.io/myjfrogtest/', credentialsId: 'jfrogid'
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
