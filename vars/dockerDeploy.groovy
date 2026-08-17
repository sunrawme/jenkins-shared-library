def call() {

    echo "This is deploying the code"

    sh '''
        docker compose pull
        docker compose up -d
    '''
}
