def call() {

    echo "This is pushing the image to Docker Hub"

    withCredentials([
        usernamePassword(
            credentialsId: "dockerhubcre",
            usernameVariable: "dockerHubUser",
            passwordVariable: "dockerHubPass"
        )
    ]) {
        sh '''
            echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
            docker tag notes-app:latest "$dockerHubUser/notes-app:latest"
            docker push "$dockerHubUser/notes-app:latest"
            docker logout
        '''
    }
}
