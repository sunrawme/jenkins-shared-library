def call(string url, String branch){
  echo "This is cloning the code"
  git url: "${url}", branch: "${branch}"
  echo "Code cloning successfully"
}
