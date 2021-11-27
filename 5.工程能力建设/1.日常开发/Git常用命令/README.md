# Git常用命令
**三层结构：**</br>
- working directory：工作区
- staging index：暂存区
- git directory：版本库 
</br>

**文件的四种状态：**</br>
- untraced：文件未被追踪
- Modified：表示工作区修改了某个文件但还没有添加到暂存区
- staged：表示把工作区修改的文件添加到了暂存区，但是没有提交到版本库
- commited：表示数据被安全地存储在版本库中 
</br>

**基本操作命令：**</br>
```shell
git init：初始化git仓库，出现.git文件
git config --global user.name JayChou：配置用户名称
git config --global user.email zhoujielun@qq.com：配置用户邮箱
git config --list：查看配置信息
git add filename：将文件添加到暂存处
git add .：将工作区下的所有修改的文件添加到暂存区
git commit -m 'description'：将暂存区的文件提交到版本库
git commit -am 'description'：跳过git add，直接将工作区所有已追踪的文件提交到版本库
git log：查看提交历史
git status：查看项目文件状态
```
</br>

**撤销操作：**</br>
```shell
git commit --amend：撤销上一次提交，并将暂存区的文件重新提交
git checkout --filename：拉去暂存区文件并用其替换工作区文件
git reset HEAD(版本号) --filename：拉取最近一次提交到版本库中的这个文件到暂存区，该操作不影响工作区
git rm --cached filename：删除暂存区文件但不删除工作区文件
git rm -f filename：同时删除工作区和暂存区文件
git mv oldname newname相当于依次执行了以下三个命令：
1）mv oldname newname
2）git rm oldname
3）git add newname
```
</br>

**分支操作：**</br>
```shell
git branch：查看分支
git branch dev：创建分支
git checkout dev：切换分支
git branch -d dev：删除分支
git branch -m dev fix：修改分支名称
git checkout -n dev：创建并切换到新分支
git merge dev：合并分支
git branch -set upstream dev(本地分支) origin/dev(远程分支)：创建本地分支并与远程分支关联
```
</br>

**比较操作：**</br>
```shell
git diff：比较工作区与暂存区之间的差异
git diff --staged：比较暂存区与版本库之间的差异
git diff 版本号 版本号：比较分支内的两个版本差异
git diff 分支 分支：比较两个分支最新提交版本的差异
```
</br>

**储存变更：**</br>
```shell
git stash：储存信息，并使工作区返回到未修改的状态
git stash list：查看所有储存信息
git stash apply stash@num：应用
```
