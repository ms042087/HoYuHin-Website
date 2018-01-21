## MyNotes

### Initialize a Git repository:  
git init

### Checking status  
git status

> staged:Files are ready to be committed.  
> unstaged:Files with changes that have not been prepared to be committed.  
> untracked:Files aren't tracked by Git yet. This usually indicates a newly created file.  
> deleted:File has been deleted and is waiting to be removed from Git.  

### Add a file to the Staging area to track  
git add <filename>  
> add all:You can also type git add -A . where the dot stands for the current directory, so everything in and beneath it is added. The -A ensures even file deletions are included.  
> git reset:You can use git reset <filename> to remove a file or files from the staging area.

### Commiting a file with a message  
git commit -m “xxx

### Adding all changes  
git add ‘*.txt’

### History  
git log  
git log –summary

### Remote repositories  
Git remote add origin <link>

### Pushing remotely  
Git push -u origin master //-u for remembering, next time can use git push

### Pulling remotely  
Git pull origin master

### Difference in file of recent changes  
Git diff HEAD

### Staged difference  
Git add <file>  
Git diff –staged

### Reset every changes after the last commit of certain file  
Git checkout -- <file>

### Create a branch  
Git branch <branchname>

### Check branch  
Git branch

### Switching branches  
Git checkout <branchname>

### Create and switch at the same time  
Git checkout -b <branchname>

### Remove a file  
Git rm <filename>

### Remove whole file  
Git rm -r <foldername>

### After changes, go to master to merge, delete the branch  
Git commit -m “xxx”  
Git checkout master  
Git merge <branchname>  
Git branch -d (-f)<branchname>  
Git push

## Useful Websites
### Downloads
[GitHub Desktop](https://desktop.github.com/)
### Basic Tutorials
[TryGit](https://try.github.io/levels/1/challenges/1)  
[MarkDown Tutorial](https://www.markdowntutorial.com/lesson/1/)
[Create GitHub Pages](http://www.cnblogs.com/purediy/archive/2013/03/07/2948892.html)
### References
[GitHub Cheat sheet](https://github.com/tiimgreen/github-cheat-sheet/blob/master/README.zh-tw.md)  
[How to use GitHub](https://github.com/xirong/my-git/blob/master/how-to-use-github.md)  
[Team Collaboration With GitHub](https://code.tutsplus.com/articles/team-collaboration-with-github--net-29876)

### Courses Links
[ELEC2543 Object-oriented programming and data structures](https://learning.hku.hk/courses/course-v1:HKU+ELEC2543+201718/courseware/88af514f0650449683f974f6474e49b2/)  
[ELEC3542 Advanced Programming and Application Development](https://learning.hku.hk/courses/course-v1:HKU+ELEC3542+201718/info)  
[ELEC4245 Digital image processing](https://www.eee.hku.hk/~elec4245/sp18/)