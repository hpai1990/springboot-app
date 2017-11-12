#!groovy

String GIT_VERSION

node {

  stage ('Checkout') {
    deleteDir()
    checkout scm
  }
  
   stage ('Build') {
    echo "Build"
  }

  stage ('Deploy to DEV') {
    echo "Deploy to DEV"
  }

}

stage 'Deploy to LIVE'
  timeout(time:2, unit:'DAYS') {
    input message:'Approve deployment to LIVE?'
  }
  node {
    echo "Deploying to Live"
  }


// vim: set syntax=groovy :
