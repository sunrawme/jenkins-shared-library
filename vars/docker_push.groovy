def call(String Project, String ImageTag, String dockerhubuser) {

    withCredentials([
        usernamePassword(
            credentialsId: 'DockerHubCred',
            usernameVariable: 'dockerHubUser',
            passwordVariable: 'dockerHubPass'
        )
    ]) {

        sh """
            echo "\$dockerHubPass" | docker login \
                -u "\$dockerHubUser" \
                --password-stdin

            docker tag ${Project}:${ImageTag} \
                ${dockerhubuser}/${Project}:${ImageTag}

            docker push \
                ${dockerhubuser}/${Project}:${ImageTag}

            docker logout
        """
    }
}
