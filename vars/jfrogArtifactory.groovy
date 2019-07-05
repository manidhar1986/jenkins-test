def uploadCode() {

	def server = Artifactory.newServer url: 'https://myjfrogtest.jfrog.io/myjfrogtest/', username: 'venkat', password: 'Test@123'
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
