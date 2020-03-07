$("#top-bar-broadcast").addClass("am-active");

//当前页 默认起始页为1
var currentPage = 1;
//每页显示的条目数
var pageSize = 6;


function putTimelines(list) {
    var timelineContainer = $("#timelineContainer");
    timelineContainer.empty();
    for (var i = 0; i < list.length; i++) {
        var timelineItem = `<div class="timeline-row-major">
    <span class="timeline-node am-animation-delay-1 am-animation-slide-top"></span>
    <div class="content am-comment-main am-animation-delay-1 am-animation-slide-top">
        <header class="am-comment-hd">
            <p class="am-comment-meta content-date">${list[i].publishDate}</p>
        </header>
        <div class="am-comment-bd">
            <div class="content-title">
                <a target="_blank" href="${list[i].sourceUrl}">${list[i].title}</a>
            </div>
        </div>
    </div>
</div>`;
        timelineContainer.append(timelineItem);
    }
}


function getTimeLineAjaxFirst(currentPage) {
    $.ajax({
        type: 'GET',
        url: '/getTimeline',
        dataType: 'json',
        data: {
            pageNum: currentPage,
            pageSize: pageSize
        },
        success: function (data) {
            putTimelines(data.body.list);
            //分页
            $("#pagination").paging({
                pageSize: data.body.pageSize,
                pageNum: data.body.pageNum,//当前所在页码
                pages: data.body.pages,//总页数
                total: data.body.totals,//总记录数
                callback: function (currentPage) {
                    getTimeLineAjaxFirst(currentPage);
                }
            });
        },
        error: function (data) {
            alert("获取分类文章失败" + data.message);
        }
    })
}

getTimeLineAjaxFirst(currentPage);