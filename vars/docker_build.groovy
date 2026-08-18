def call(String projectName, String ImageTag, String DockerHubuser){
   sh "docker build -t ${DockerHubeuser}/${projectName}:${ImageTag} ."
}
