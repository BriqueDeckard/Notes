# WSL+Docker: Kubernetes on the Windows Desktop: 
<details>
	<summary>Sources:</summary>https://kubernetes.io/blog/2020/05/21/wsl-docker-kubernetes-on-the-windows-desktop/</details>


## Prerequisites: 

Since we will explain how to install KinD, we won't go into too much detail around the installation of KinD's dependencies.

However, here is the list of the prerequisites needed and their version/lane:

OS: Windows 10 version 2004, Build 19041
WSL2 enabled
In order to install the distros as WSL2 by default, once WSL2 installed, run the command wsl.exe --set-default-version 2 in Powershell
WSL2 distro installed from the Windows Store - the distro used is Ubuntu-18.04
Docker Desktop for Windows, stable channel - the version used is 2.2.0.4
[Optional] Microsoft Terminal installed from the Windows Store
Open the Windows store and type "Terminal" in the search, it will be (normally) the first option
Windows Store Terminal

And that's actually it. For Docker Desktop for Windows, no need to configure anything yet as we will explain it in the next section.

## WSL2: First contact: 

Once everything is installed, we can launch the WSL2 terminal from the Start menu, and type "Ubuntu" for searching the applications and documents:

Once found, click on the name and it will launch the default Windows console with the Ubuntu bash shell running.

Like for any normal Linux distro, you need to create a user and set a password:

## Update Ubuntu: 

Before we move to the Docker Desktop settings, let's update our system and ensure we start in the best conditions:

```
# Update the repositories and list of the packages available
sudo apt update

# Update the system based on the packages installed > the "-y" will approve the change automatically
sudo apt upgrade -y
```

## Docker Desktop: faster with WSL2: 
Before we move into the settings, let's do a small test, it will display really how cool the new integration with Docker Desktop is:

```
# Try to see if the docker cli and daemon are installed
docker version
# Same for kubectl
kubectl version
```

You got an error? Perfect! It's actually good news, so let's now move on to the settings

## Docker Desktop settings: enable WSL2 integration: 

First let's start Docker Desktop for Windows if it's not still the case. Open the Windows start menu and type "docker", click on the name to start the application.

One in the application, click on "settings" and click the "Enable the experimental WSL 2 based engine" and click "Apply & Restart".

What this feature did behind the scenes was to create two new distros in WSL2, containing and running all the needed backend sockets, daemons and also the CLI tools (read: docker and kubectl command).

Still, this first setting is still not enough to run the commands inside our distro. If we try, we will have the same error as before.

In order to fix it, and finally be able to use the commands, we need to tell the Docker Desktop to "attach" itself to our distro also.

Let's now switch back to our WSL2 terminal and see if we can (finally) launch the commands:
```
# Try to see if the docker cli and daemon are installed
docker version
# Same for kubectl
kubectl version
```

### Answer for Docker: 
```
Client: Docker Engine - Community
 Cloud integration: 1.0.17
 Version:           20.10.8
 API version:       1.41
 Go version:        go1.16.6
 Git commit:        3967b7d
 Built:             Fri Jul 30 19:54:22 2021
 OS/Arch:           linux/amd64
 Context:           default
 Experimental:      true

Server: Docker Engine - Community
```
### Answer for Kubectl:

