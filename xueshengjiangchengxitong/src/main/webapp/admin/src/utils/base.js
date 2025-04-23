const base = {
    get() {
        return {
            url : "http://localhost:8080/xueshengjiangchengxitong/",
            name: "xueshengjiangchengxitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xueshengjiangchengxitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "学生奖惩管理系统"
        } 
    }
}
export default base
