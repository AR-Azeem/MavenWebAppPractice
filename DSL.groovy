job('Maven DSL project'){
    description("first maven project for DSl script")
    scm {
        git("https://github.com/AR-Azeem/MavenPrac.git",'master')
    }
    triggers{
        scm('* * * * *')
    }
    steps{
        maven('clean package','pom.xml')
    }
    publishers{
        archiveArtifacts '**/*.jar'
    }
}