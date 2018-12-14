<%--
  Created by IntelliJ IDEA.
  User: Zhangsnke
  Date: 2018/11/8
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .progress_bar {
        margin-top: 0%;
    }

</style>
<body>

<div class="secher">

    <h1 class="pd-5-20">人群分类</h1>
</div>
<div class="secher bg-gray">
    <div class="moudle_list pd-5-20">
        <div class="moudle_2 bg-white">
            <label class="block bg-orange c-white text-c pd-5-20" style="cursor: default">高血压</label>
            <div class="fl">
                <h2 class="mt-10" id="gxyNum" style="cursor: pointer" name="click"></h2>
                <input type="hidden" name="gxyNum" value="01">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="gxyPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="gxyPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="moudle_2 bg-white">
            <label class="block bg-fenlei-2 c-white text-c pd-5-20" style="cursor: default">糖尿病</label>
            <div class="fl">
                <h2 class="mt-10" id="tnbNum" style="cursor: pointer" name="click" ></h2>
                <input type="hidden" name="tnbNum" value="02">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="tnbPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="tnbPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="moudle_2 bg-white">
            <label class="block bg-fenlei-3 c-white text-c pd-5-20" style="cursor: default">脑卒中高危</label>
            <div class="fl">
                <h2 class="mt-10" id="nczNum" style="cursor: pointer" name="click" ></h2>
                <input type="hidden" name="nczNum" value="03">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="nczPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="nczPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="moudle_2 bg-white">
            <label class="block bg-fenlei-4 c-white text-c pd-5-20" style="cursor: default">肿瘤</label>
            <div class="fl">
                <h2 class="mt-10" id="zlNum" style="cursor: pointer" name="click"></h2>
                <input type="hidden" name="zlNum" value="04">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="zlPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="zlPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="moudle_2 bg-white">
            <label class="block bg-fenlei-5 c-white text-c pd-5-20" style="cursor: default">肿瘤高危</label>
            <div class="fl">
                <h2 class="mt-10" id="zlgwNum" style="cursor: pointer" name="click" ></h2>
                <input type="hidden" name="zlgwNum" value="05">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="zlgwPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="zlgwPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="moudle_2 bg-white">
            <label class="block bg-fenlei-6 c-white text-c pd-5-20" style="cursor: default">肺结核</label>
            <div class="fl">
                <h2 class="mt-10" id="fjhNum" style="cursor: pointer" name="click"></h2>
                <input type="hidden" name="fjhNum" value="08">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="fjhPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="fjhPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="moudle_2 bg-white">
            <label class="block bg-fenlei-7 c-white text-c pd-5-20" style="cursor: default">老年人</label>
            <div class="fl">
                <h2 class="mt-10" id="lnrNum" style="cursor: pointer" name="click" ></h2>
                <input type="hidden" name="lnrNum" value="09">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="lnrPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="lnrPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="moudle_2 bg-white mt-10">
            <label class="block bg-fenlei-8 c-white text-c pd-5-20" style="cursor: default">0-6岁儿童</label>
            <div class="fl">
                <h2 class="mt-10" id="kidsNum" style="cursor: pointer" name="click" ></h2>
                <input type="hidden" name="kidsNum" value="07">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="kidsPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="kidsPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="moudle_2 bg-white mt-10">
            <label class="block bg-fenlei-9 c-white text-c pd-5-20" style="cursor: default">孕产妇</label>
            <div class="fl">
                <h2 class="mt-10" id="ycfNum" style="cursor: pointer" name="click" ></h2>
                <input type="hidden" name="ycfNum" value="06">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="ycfPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="ycfPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="moudle_2 bg-white mt-10">
            <label class="block bg-fenlei-10 c-white text-c pd-5-20" style="cursor: default">精神病</label>
            <div class="fl">
                <h2 class="mt-10" id="jsbNum" style="cursor: pointer" name="click" ></h2>
                <input type="hidden" name="jsbNum" value="10">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="jsbPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr">
                    <div name="jsbPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="moudle_2 bg-white mt-10">
            <label class="block bg-fenlei-11 c-white text-c pd-5-20" style="cursor: default">残疾人</label>
            <div class="fl">
                <h2 class="mt-10" id="cjrNum" style="cursor: pointer" name="click"></h2>
                <input type="hidden" name="cjrNum" value="11">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="cjrPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="cjrPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="moudle_2 bg-white mt-10">
            <label class="block bg-fenlei-12 c-white text-c pd-5-20" style="cursor: default">贫困人口</label>
            <div class="fl">
                <h2 class="mt-10" id="pkNum" style="cursor: pointer" name="click" ></h2>
                <input type="hidden" name="pkNum" value="12">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="pkPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="pkPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="moudle_2 bg-white mt-10">
            <label class="block bg-fenlei-13 c-white text-c pd-5-20" style="cursor: default">计生特殊</label>
            <div class="fl">
                <h2 class="mt-10" id="jstsNum" style="cursor: pointer" name="click" ></h2>
                <input type="hidden" name="jstsNum" value="13">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="jstsPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="jstsPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="moudle_2 bg-white mt-10">
            <label class="block bg-fenlei-14 c-white text-c pd-5-20" style="cursor: default">死亡</label>
            <div class="fl">
                <h2 class="mt-10" id="swNum" style="cursor: pointer" name="click" ></h2>
                <input type="hidden" name="swNum" value="14">
                <h4>人</h4>
            </div>
            <div class="fr"><label id="swPre" class="fl mt-10" style="cursor: default"></label>
                <div class="progress_bar fr mt-10">
                    <div name="swPre">
                        <div class="therm outer-therm vertical">
                            <div class="therm  vertical" style=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $.ajax({
            url: '${ctx}/home/data',
            type: "post",
            contentType: "application/json;charset=utf-8",
            success: function (result) {
                var data = result;
                for (var k in data) {
                    $("#" + k + "").text(data[k]);
                    $("div[name=" + k + "]").css("height", data[k]);
                    setJQmeter( k ,data[k]);
                }

            }
        });
    });

    function setJQmeter(id, persent) {
        $('div[name=' + id+']').jQMeter({
            goal: '100',
            raised: persent,
            orientation: 'vertical',
            height: '36px',
            animationSpeed:1000,
            counterSpeed:1000
        });
    }
</script>
</body>
</html>
