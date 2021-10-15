pipelineJob("atsp-nightly") {
  keepDependencies(false)
  definition {
    cpsScm {
      scm {
        git {
          remote {
            credentials("github_user")
            url('https://github.com/DennisJensen95/MiR-ATSP.git') 
          }
	        branch('*/main')
        }
      }
      lightweight()
    }
  }
  properties {
        pipelineTriggers {
            triggers {
                pollSCM {
                    scmpoll_spec('@midnight')
                }
            }
        }
  }
}
