/**
 * form提交相关方法
 */
mini_debugger = false;
$(function () {
    initToolTip();
    smokeValueChange();
    $.ajaxSetup({
        global: true,
        complete: function (request, textStatus) {
            //this; // 调用本次AJAX请求时传递的options参数
            try {
                var result = $.parseJSON(request.responseText);
                if (result.ok == false && result.message == "登录超时") {
                    window.location.href = ctx + "/login";
                }
            } catch (e) {
            }
        }
    });
    $("#keyword").bind('keydown', function (e) {
        var key = e.keyCode;
        if (key == 13) {
            $(this).next()[0].click();
        }
    });

});

// 一个中文字符按照两个字符长度计算,例子: "中文".len()
String.prototype.len = function () {
    return this.replace(/[^\x00-\xff]/g, "**").length;
}

function getLoactionIp() {
    var weburl = document.location.href;
    var weburl_ip = weburl.substring(weburl.indexOf(':') + 3);
    var ip = weburl_ip.substring(0, weburl_ip.indexOf(':'));
    return ip;
}

function clearDatePicker(e) {
    if (e != undefined && e.sender != undefined) {
        var date = e.sender;
        if (!date.isValid()) {
            date.setValue("");
            date.setText("");
        }
    }
}

$.isEmpty = function (v) {
    return v == null || v == "" || v == undefined;
}
$.getEmptyValue = function (v) {
    if ($.isEmpty($.trim(v))) {
        return "";
    }
    return v;
}
function showActionAjaxResult(ajaxResult) {
    var data = eval(ajaxResult);
    if (data.ok) {
        showActionMessage("success", data.message);
    } else {
        showActionMessage("danger", data.message);
    }

}
function showActionMessage(state, message) {
    mini.showTips({
        content: message,
        state: state,
        x: "Center",
        y: "Center",
        timeout: 2000
    });
}

function gridLoadSuccess(sender) {
    try {
        if (sender.data.length == 0) {
            var result = $.parseJSON(sender.text);
            if (result.ok == false && result.message == "登录超时") {
                window.location.href = ctx + "/login";
            } else {
                showActionMessage("info", "未检索到任何符合条件的结果");
            }
        } else {
            positionFooter();
        }
    } catch (e) {
    }
}

function gridLoadError(sender, xhr, errorMsg, errorCode) {
    /*try {
        var text = sender.xhr.responseText;
        if ($.trim(text) != "") {
            mini.showTips({
                content: text,
                state: "danger",
                x: "center",
                y: "center",
                timeout: 3000
            });
        }
    } catch (e) {
    }*/
}

/**
 * data-tooltip="显示内容"
 * title="显示内容"
 * data-placement="left|top|right|bottom|topleft|topright|bottomleft|bottomright"
 */
function initToolTip() {
    var tip = new mini.ToolTip();
    tip.set({
        target: document,
        selector: '[data-tooltip]'
    });
}
//通过吸烟状况来判断吸烟频率的是否需要填写
function smokeValueChange() {
    try {
        var smokeInput = mini.get("smoke");
        if (smokeInput != undefined) {
            var smoke = smokeInput.getValue();
            if (smoke == "0" || smoke == "1" || smoke == '') {
                mini.get("dailySmoke").disable();
                mini.get("dailySmoke").setValue();
            } else {
                mini.get("dailySmoke").enable();
            }

            var lastSmoke = mini.get("lastSmoke");
            if (lastSmoke != undefined) {
                if (smoke == "0" || smoke == '') {
                    lastSmoke.disable();
                    lastSmoke.setValue();
                } else {
                    lastSmoke.enable();
                }
            }

        }
    } catch (e) {

    }
}

//通过饮酒状况来判断日饮酒量和饮酒时长是否需要填写
function drinkValueChange() {
    try {
        var drinkInput = mini.get("drink");
        if (drinkInput != undefined) {
            var drink = drinkInput.getValue();
            if (drink == "1" || drink == '') {
                mini.get("giveupDrink_drink").disable();
                mini.get("giveupDrink_drink").setValue();
            } else {
                mini.get("giveupDrink_drink").enable();
            }

            var lastDrink = mini.get("lastDrink");
            if (lastDrink != undefined) {
                if (drink == "1" || drink == '') {
                    lastDrink.disable();
                    lastDrink.setValue();
                } else {
                    lastDrink.enable();
                }
            }

        }
    } catch (e) {

    }
}

//通过锻炼频率来判断每次锻炼时间和锻炼方式是否需要填写
function acttypeValueChange() {
    try {
        var acttypeInput = mini.get("acttype");
        if (acttypeInput != undefined) {
            var acttype = acttypeInput.getValue();
            if (acttype == "0" || acttype == '') {
                mini.get("actduration").disable();
                mini.get("actduration").setValue();

                mini.get("actintro").disable();
                mini.get("actintro").setValue();
            } else {
                mini.get("actduration").enable();
                mini.get("actintro").enable();
            }

        }
    } catch (e) {

    }
}
//通过低血糖反应来判断主要症状是否需要填写
function glucopeniaValueChange() {
    try {
        var glucopeniaInput = mini.get("glucopenia");
        if (glucopeniaInput != undefined) {
            var glucopenia = glucopeniaInput.getValue();
            if (glucopenia == "1" || glucopenia == '') {
                mini.get("symptomText").disable();
                mini.get("symptomText").setValue();
            } else {
                mini.get("symptomText").enable();
            }

        }
    } catch (e) {

    }
}

/**
 * 判断饮酒情况
 * @param styleClass
 * @param value
 * @param itemCode
 */
function tiggerGiveupDrink(styleClass, value, itemCode) {
    try {
        var name = $(styleClass).attr("prefix");
        if ("1" == itemCode) {
            $("#" + name + "_drink_div").hide();
            mini.get(name + "_drink").setValue();
            mini.get(name + "_drink").disable();

            mini.get("drink").setValue();
            mini.get("drink").disable();
        } else if ("0" == itemCode) {
            $("#" + name + "_drink_div").show();
            mini.get(name + "_drink").enable();
            mini.get("drink").enable();
        }
    } catch (e) {

    }
}
/**
 * 根据选择的值判断日期是否显示和隐藏
 * @param styleClass
 * @param value
 * @param itemCode
 */
function tiggerDate(styleClass, value, itemCode) {
    var name = $(styleClass).attr("prefix");
    if ("0" == itemCode) {
        $("#" + name + "_date_div").hide();
        mini.get(name + "_date").disable();
        $("#" + name + "Title").css("color", "black");
    } else if ("1" == itemCode) {
        $("#" + name + "_date_div").show();
        mini.get(name + "_date").enable();
        $("#" + name + "Title").css("color", "red");
    }
}
function setChangeTeam(id, orgId) {
    setTeamUrl(id, mini.get(orgId).getValue());
}
function setTeam(teamId, userId) {
    var team = mini.get(teamId);
    var user = mini.get(userId);
    var value = user.getValue();
    if (value != "") {
        $.ajax({
            url: ctx + "/diabetes/teamInfo/teamByUser?userId=" + value,
            success: function (teamId) {
                if (teamId != "") {
                    team.setValue(teamId);
                    team.validate();
                }
            }
        })
    }

}
/**
 * 设置团队的id和机构code
 * @param id 团队下拉框id
 * @param hospitalId 医疗机构代码
 */
function setTeamUrl(id, hospitalId, userId) {
    var team = mini.get(id);
    var user = null;
    if (userId != undefined && userId != null) {
        user = mini.get(userId);
    }
    if (team != undefined && team != null && hospitalId != undefined && hospitalId != "") {
        if (user != undefined && user != null) {
            team.setUrl(ctx + "/diabetes/teamInfo/data?hospitalId=" + hospitalId + "&userId=" + user.getValue());
        } else {
            team.setUrl(ctx + "/diabetes/teamInfo/data?hospitalId=" + hospitalId);
        }
    }
}
/**
 * @param id
 * @param teamId
 */
function setUserUrl(id, teamId) {
    var user = mini.get(id);
    var team = mini.get(teamId);
    if (user != undefined && user != null) {
        user.setUrl(ctx + "/sys/user/usersData?teamId=" + team.getValue());
    }
}
/**==============街道和居委的两级联动 Start===============**/
function setLinkageTownValue(townId, committeeId, value) {
    var town = mini.get(townId);
    if (value != undefined && value != null && value != "") {
        town.setUrl(ctx + "/sys/dicArea/queryByOrgCode?level=4&code=" + value);
        town.select(0);
    } else {
        town.setUrl(ctx + "/sys/dicArea/queryByOrgCode?level=4&code=");
    }
    town.setValue("");
    town.setText("");
    mini.get(committeeId).setValue("");
    mini.get(committeeId).setText("");
}
function setLinkageTown(townId, committeeId, orgId) {
    var town = mini.get(townId);
    var value = mini.get(orgId).getValue();
    if (value != undefined && value != null && value != "") {
        town.setUrl(ctx + "/sys/dicArea/queryByOrgCode?level=4&code=" + value);
        town.select(0);
    } else {
        town.setUrl(ctx + "/sys/dicArea/queryByOrgCode?level=4&code=");
    }
    town.setValue("");
    town.setText("");
    mini.get(committeeId).setValue("");
    mini.get(committeeId).setText("");
}
function setLinkageCommittee(townId, committeeId) {
    var town = mini.get(townId);
    var value = town.getValue();
    var committee = mini.get(committeeId);

    if (value != undefined && value != null && value != "") {
        committee.setUrl(ctx + "/sys/dicArea/queryAddress?level=5&pid=" + value);
        committee.select(0);
    } else {
        committee.setUrl(ctx + "/sys/dicArea/queryAddress?level=5&pid=");
    }
    committee.setValue("");
    committee.setText("");
}
function setLinkageDoc(teamId, docId) {
    var team = mini.get(teamId);
    var value = team.getValue();
    var doc = mini.get(docId);

    if (value != undefined && value != null && value != "") {
        doc.setUrl(ctx + "/sys/dicArea/queryDoc?teamId=" + value);
        doc.select(0);
    } else {
        doc.setUrl(ctx + "/sys/dicArea/queryDoc?teamId=");
    }
    doc.setValue("");
    doc.setText("");
}
/**==============街道和居委的两级联动 End===============**/
function setAddressUrl(childId, id, url) {
    var input = mini.get(id);
    var child = mini.get(childId);
    var value = input.getValue();
    if (value != undefined && value != null && value != "") {
        child.setUrl(url + "&pid=" + value);
        child.select(0);
    } else {
        child.setUrl(url + "&pid=");
    }
}

function getBirthDayAndSex(idcard) {
    if (IsIdCard(idcard)) {
        try {
            var birth = idcard.substring(6, 10) + "-" + idcard.substring(10, 12) + "-" + idcard.substring(12, 14);
            var sex = undefined;
            if (parseInt(idcard.substr(16, 1)) % 2 == 1) {
                //男
                sex = 1;
            } else {
                //女
                sex = 2;
            }
            return {"birthday": birth, "sex": sex}
        } catch (e) {
        }
    }
    return {"birthday": "", "sex": ""}
}

function workstation(result) {
    setTimeout(function () {
        var userAgent = navigator.userAgent;
        if (userAgent.indexOf("Firefox") != -1 || userAgent.indexOf("Chrome") != -1) {
            window.location.href = "about:blank";
            //window.open('','_self','');
        } else {
            window.opener = null;
            window.open("", "_self");
            window.close();
        }
    }, 2000);
    info = result.message + "<br/>2秒后自动关闭";
    mini.showTips({
        content: info,
        state: "success",
        x: "center",
        y: "center",
        timeout: 3000
    });
}

function validateForm(formId){
    var form;
    if(formId.indexOf("#")>=0){
        form = new mini.Form(formId);
    }else {
        form = new mini.Form("#"+formId);
    }
    var fields = form.getValidateFields();
    for (var i = 0; i < fields.length; i++) {
        var vtype = fields[i].vtype;
        if (vtype != undefined && vtype.indexOf("decimal1") >= 0) {
            var text = fields[i].getValue();
            if ($.trim(text) == "") {
                continue;
            }
            var arr = text.split('\.');
            if (arr.length == 2) {
                if (arr[1].length == 0) {
                    fields[i].setValue(text + "0");
                }
            } else if (arr.length == 1) {
                fields[i].setValue(text + ".0");
            }
        } else if (vtype != undefined && vtype.indexOf("decimal2") >= 0) {
            var text = fields[i].getValue();
            if ($.trim(text) == "") {
                continue;
            }
            var arr = text.split('\.');
            if (arr.length == 2) {
                if (arr[1].length == 1) {
                    fields[i].setValue(text + "0");
                } else if (arr[1].length == 0) {
                    fields[i].setValue(text + "00");
                }
            } else if (arr.length == 1) {
                fields[i].setValue(text + ".00");
            }
        }
    }
    form.validate();
    var result = false;
    var data = form.getData("yyyy-MM-dd", false);
    $("#" + formId).find("input:hidden").each(function () {
        var name = $(this).attr("name");
        var value = $(this).val();
        if (name != undefined) {
            if (data[name] != undefined && $("#" + formId).find("input[name='" + name + "']").size() > 1) {
                data[name] = data[name] + "," + value;
            } else {
                data[name] = value;
            }
            var required = $(this).attr("must");
            if (required == "true") {
                var id = $(this).attr("id");
                if ($.trim(value) == "") {
                    var requiredMessage = $(this).attr("mustMessage");
                    $("#" + id + "Error").text(requiredMessage);
                    result = true;
                    var index = $(this).attr("index");
                    if ($("#checkLabel" + name + index).size() > 0) {
                        $("#checkLabel" + name + index).focus();
                    } else if ($("#checkLabel" + name + index + "1").size() > 0) {
                        $("#checkLabel" + name + index + "1").focus();
                    }

                } else {
                    $("#" + id + "Error").text("");
                }
            }
        }
    });
    if (result) {
        return false;
    }
    return form.isValid();
}

function submitForm(formId, url, skipUrl, fun) {
    var form;
    if(formId.indexOf("#")>=0){
        form = new mini.Form(formId);
    }else {
        form = new mini.Form("#"+formId);
    }
    var fields = form.getValidateFields();
    for (var i = 0; i < fields.length; i++) {
        var vtype = fields[i].vtype;
        if (vtype != undefined && vtype.indexOf("decimal1") >= 0) {
            var text = fields[i].getValue();
            if ($.trim(text) == "") {
                continue;
            }
            var arr = text.split('\.');
            if (arr.length == 2) {
                if (arr[1].length == 0) {
                    fields[i].setValue(text + "0");
                }
            } else if (arr.length == 1) {
                fields[i].setValue(text + ".0");
            }
        } else if (vtype != undefined && vtype.indexOf("decimal2") >= 0) {
            var text = fields[i].getValue();
            if ($.trim(text) == "") {
                continue;
            }
            var arr = text.split('\.');
            if (arr.length == 2) {
                if (arr[1].length == 1) {
                    fields[i].setValue(text + "0");
                } else if (arr[1].length == 0) {
                    fields[i].setValue(text + "00");
                }
            } else if (arr.length == 1) {
                fields[i].setValue(text + ".00");
            }
        }
    }
    form.validate();
    if (form.isValid() == false) {
        for (var i = 0; i < fields.length; i++) {
            if (fields[i].isValid() == false) {
                fields[i].focus();
                return;
            }
        }
        return;
    }
    var result = false;
    var data = form.getData("yyyy-MM-dd", false);
    $("#" + formId).find("input:hidden").each(function () {
        var name = $(this).attr("name");
        var value = $(this).val();
        if (name != undefined) {
            if (data[name] != undefined && $("#" + formId).find("input[name='" + name + "']").size() > 1) {
                data[name] = data[name] + "," + value;
            } else {
                data[name] = value;
            }
            var required = $(this).attr("must");
            if (required == "true") {
                var id = $(this).attr("id");
                if ($.trim(value) == "") {
                    var requiredMessage = $(this).attr("mustMessage");
                    $("#" + id + "Error").text(requiredMessage);
                    result = true;
                    var index = $(this).attr("index");
                    if ($("#checkLabel" + name + index).size() > 0) {
                        $("#checkLabel" + name + index).focus();
                    } else if ($("#checkLabel" + name + index + "1").size() > 0) {
                        $("#checkLabel" + name + index + "1").focus();
                    }

                } else {
                    $("#" + id + "Error").text("");
                }
            }
        }
    });
    if (result) {
        return
    }
    myAjaxSubmit(url, data, skipUrl, fun);
}
var ajax_sumbmit = true;
function myAjaxSubmit(url, data, skipUrl, fun) {
    if (ajax_sumbmit) {
        ajax_sumbmit = false;
        mini.mask({
            el: document.body,
            cls: 'mini-mask-loading',
            html: '加载中...'
        });
        $.ajax({
            url: url,
            type: "post",
            data: data,
            success: function (result) {
                ajax_sumbmit = true;
                mini.unmask(document.body);
                if (result.ok) {
                    var info = result.message;
                    if (fun != undefined && fun != "") {
                        eval(fun).apply(this, [result]);
                    } else {
                        setTimeout(function () {
                            window.location.href = skipUrl;
                        }, 2000);
                        info = result.message + "<br/>2秒后自动跳转";
                        mini.showTips({
                            content: info,
                            state: "success",
                            x: "center",
                            y: "center",
                            timeout: 3000
                        });
                    }
                } else {
                    mini.showTips({
                        content: result.message,
                        state: "danger",
                        x: "center",
                        y: "center",
                        timeout: 3000
                    });
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                ajax_sumbmit = true;
                mini.unmask(document.body);
                var message = XMLHttpRequest.responseText;
                if ($.trim(message) == "") {
                    message = "错误";
                }
                mini.showTips({
                    content: message,
                    state: "danger",
                    x: "center",
                    y: "center",
                    timeout: 3000
                });
            }
        });
    } else {
        mini.showTips({
            content: "正在提交中...",
            state: "danger",
            x: "center",
            y: "center",
            timeout: 3000
        });
    }
}
//定义positionFooter function
function positionFooter() {
    var footerHeight = 0, footerTop = 0;
    //$footer.css("height", "0px");
    //$("#footer").removeAttr("style");
    //取到div#footer高度
    //footerHeight = $footer.height();
    footerHeight = 30;
    //div#footer离屏幕顶部的距离
    var scrollTop = $(window).scrollTop();
    var height = $(window).height();
    var hx = 0;
    if ($.browser.msie) {
        footerTop = (scrollTop + height - footerHeight) + "px";
        hx = $("body").height() + footerHeight;
    } else {
        footerTop = (height - footerHeight) + "px";
        hx = $("html").height() + footerHeight;
    }
    //如果页面内容高度小于屏幕高度，div#footer将绝对定位到屏幕底部，否则div#footer保留它的正常静态定位
    var style = "";
    if (hx < height) {
        /*$("#footer").css({
         position: "absolute",
         top: footerTop
         });*/
        style = "position: absolute; height: 28px; top:" + footerTop + ";";
    } else {
        /*$("#footer").css({
         position: "static",
         top: ''
         });*/
        style = "position: static;height: 28px;";
    }

    $("#footer").attr("style", style);
}
/**
 * 医院，团队，医生三级联动
 * @param orgId
 * @param teamId
 * @param permission
 */
function loadteam(orgId, teamId, docId, permission) {
    var dutyorg = mini.get(orgId);
    var team = mini.get(teamId);
    var dutydoc = mini.get(docId);
    var url = ctx + "/doctor/task/team?dutyorg=" + dutyorg.getValue() + "&permission=" + permission;
    team.load(url);
    team.setValue("");
    dutydoc.setValue("");
    loadDoctor(orgId, teamId, docId, permission);
}
function loadDoctor(orgId, teamId, docId, permission) {
    var dutyorg = mini.get(orgId);
    var team = mini.get(teamId);
    var dutydoc = mini.get(docId);
    var url = ctx + "/doctor/task/doctor?dutyorg=" + dutyorg.getValue() + "&team=" + team.getValue() + "&permission=" + permission;
    dutydoc.load(url);
    dutydoc.setValue("");
}
//根据生日计算年龄
function getAge(birthday) {
    var age = '';
    if (birthday == "") {
        return "";
    } else {
        var date = new Date(birthday.replace(/-/g,'/').replace(/T|Z/g,' ').trim());
        var today = new Date();
        var thisYear = today.getFullYear();
        var thisMonth = today.getMonth() + 1;
        var thisDay = today.getDate();
        var birYear = date.getFullYear();
        var birMonth = date.getMonth() + 1;
        var birDay = date.getDate();
        if (thisYear - birYear >= 0) {
            if (thisMonth - birMonth < 0) {
                age = thisYear - birYear - 1;
            }
            else {
                if (thisDay - birDay >= 0) {
                    age = thisYear - birYear;
                }
                else {
                    age = thisYear - birYear - 1;
                }
            }
        }
    }
    return age
}