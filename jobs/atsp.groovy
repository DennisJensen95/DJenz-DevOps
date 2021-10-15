multibranchPipelineJob('atsp') {
    branchSources {
        branchSource {
            source {
                git {
                    credentialsId("github_user")
                    browser {
                        gitWeb {
                            repoUrl("https://github.com/DennisJensen95/MiR-ATSP.git")
                        }
                    }
                    remote("https://github.com/DennisJensen95/MiR-ATSP.git")
                    gitTool("/usr/bin/git")

                    traits {
                        wipeWorkspaceTrait()
                        gitBranchDiscovery()
                        gitHubTagDiscovery()
                        gitHubBranchDiscovery {
                            strategyId(1)
                        }
                        gitHubPullRequestDiscovery {
                            strategyId(1)
                        }
                        
                    }   
                }

            }
        }
    }
    triggers {
        periodicFolderTrigger {
            interval("5")
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}
