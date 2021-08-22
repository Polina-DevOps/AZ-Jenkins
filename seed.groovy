folder('CI-Pipelines') {
    displayName('CI-Pipelines')
    description('CI-Pipelines')
}

pipelineJob('CI-Pipelines/frontend') {
    configure { flowdefinition ->
        flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
            'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://DevOps-Batches@dev.azure.com/DevOps-Batches/DevOps57/_git/frontend')
                    }
                }
                'branches' {
                    'hudson.plugins.git.BranchSpec' {
                        'name'('*/master')
                    }
                }
            }
            'scriptPath'('Jenkinsfile')
            'lightweight'(true)
        }
    }
}

