#!groovy

String GIT_VERSION

node {

  def buildEnv
  def devAddress

  stage ('Checkout') {
    deleteDir()
    checkout scm
    GIT_VERSION = sh (
      script: 'git describe --tags',
      returnStdout: true
    ).trim()
  }

  stage ('Build Custom Environment') {
    buildEnv = docker.build("build_env:${GIT_VERSION}", 'custom-build-env')
  }

  buildEnv.inside {

    stage ('Build') {
      sh 'mvn install'
    }
      
    stage ('Prepare Docker Image') {
      echo "Prepare docker image"
    }
  }

  stage ('Build and Push Docker Image') {
     echo "Build and Push Docker Image"
  }

  stage ('Deploy to DEV') {
    echo "Build and Push Docker Image"
  }

}

stage 'Deploy to LIVE'
  timeout(time:2, unit:'DAYS') {
    input message:'Approve deployment to LIVE?'
  }
  node {
    deployContainer("sambott/grpc-test:${GIT_VERSION}", 'LIVE')
  }


// vim: set syntax=groovy :
