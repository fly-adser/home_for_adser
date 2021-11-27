# Git常用命令
**三层结构：**</br>
- working directory，工作区
- staging index，暂存区
- git directory，版本库 
</br>

**文件的四种状态：**</br>
- untraced，文件未被追踪
- Modified，表示工作区修改了某个文件但还没有添加到暂存区
- staged，表示把工作区修改的文件添加到了暂存区，但是没有提交到版本库
- commited，表示数据被安全地存储在版本库中 
</br>

**基本操作命令：**</br>
git init：初始化git仓库，出现.git文件</br>
git config --global user.name JayChou：配置用户名称</br>
git config --global user.email zhoujielun@qq.com：配置用户邮箱</br>
git config --list：查看配置信息
git add filename：将文件添加到暂存处</br>
git add .：将工作区下的所有修改的文件添加到暂存区</br>
git commit -m 'description'：将暂存区的文件提交到版本库</br>
git commit -am 'description'：跳过git add，直接将工作区所有已追踪的文件提交到版本库</br>
git log：查看提交历史</br>
git status：查看项目文件状态</br>
</br>

**撤销操作：**</br>
git commit --amend：撤销上一次提交，并将暂存区的文件重新提交
git checkout --filename：拉去暂存区文件并用其替换工作区文件</br>
git reset HEAD(版本号) --filename：拉取最近一次提交到版本库中的这个文件到暂存区，该操作不影响工作区</br>
git rm --cached filename：删除暂存区文件但不删除工作区文件</br>
git rm -f filename：同时删除工作区和暂存区文件</br>
git mv oldname newname相当于依次执行了以下三个命令：</br>
1）mv oldname newname</br>
2）git rm oldname</br>
3）git add newname</br>
</br>

**分支操作：**</br>
git branch：查看分支</br>
