0. Install Git
1. Create a repository in GitHub
2. Create a local working folder
```mkdir newFolder && cd newFolder```
3. Initialization and Link with repository  
```git init```  
You can see  
```Initialized empty Git repository in /path/newFolder/.git/```  
Then configure the user information  
```git config user.email "xxx@gmail.com"```  
```git config user.name "xxx"```  
Then link with remote repository  
```git remote add origin https://github.com/xxx/yyy.git```
4. Create a file and upload it  
```sudo touch a.py```  
Add single file ```git add a.py```  
Add all file ```git add .```  
Commit  
```git commit -m "initial commit"```  
You can see  
```master ... 1 file changed ... created mode ...```  
Push to the remote repository  
```git push -u origin master```  
You can see  
```Writing object ... done.```  
```Branch master set up to track remote branch master from origin```  

Now go to the github repository, you can see the a.py has been uploaded.  

Also, Enter ```git status```, you can see
```On branch master```  
```Your branch is up to date with origin/master```

now you have  **origin/master as remote branch** and **master as local branch**  

Enter ```git branch```, you can see
```* master```  
The * indicates that we are in master branch

5. Create a new branch and merge changes  
```git checkout -b newBranch```  
You can see  
```Switched to a new branch 'newBranch'```  
Enter ```git branch```, you can see
```master```  
```* newBranch```  
Add text "123" into the a.py and add&commit  
```git add .```  
```git commit -m "Initial commit from newBranch"```  
For the first push, you need to create a new branch so enter  
```git push --set-upstream origin newBranch```  
For later commit, you can just enter  
```git push```  

You can see a.py has been uploaded to newBranch on GitHub  

Now switch back to master branch by ```git checkout master```  
By showing the content of the a.py by typing ```cat a.py```, which return nothing, you can confirm that we switch back to old branch. We then merge the master branch with the newBranch to update files.  

Enter ```git merge newBranch```  then  
```git add .```  
```git commit -m "updated from newBranch"```  
```git push```  

You can see a.py has been updated on master branch on GitHub

6. Update the local repository  
We update the a.py on master branch with line 2 = abc  
