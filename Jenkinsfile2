pipeline
{
	agent any

	stages
	{
		stage('Bilding JAR')
		{
			steps
			{
				bat "mvn clean package -DskipTests"
			}
		}

		stage('Building Image')
		{
			steps
			{
				bat "docker build -t=8669043558/guru99latest ."
			}
		}

		stage('Push Images')
		{
			steps
			{
				bat "docker push 8669043558/guru99latest"
			}
		}
	}
}