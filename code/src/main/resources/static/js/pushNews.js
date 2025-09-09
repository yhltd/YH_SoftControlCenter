// 修复后的setTable函数
function setTable(data) {
    // 确保表格容器存在
    var $tableContainer = $('.table-div');
    if ($tableContainer.length === 0) {
        console.error('表格容器 .table-div 不存在');
        return;
    }

    // 检查表格是否已存在，如果不存在则创建
    var $table = $('#data-table');
    if ($table.length === 0) {
        $tableContainer.html(`
            <table id="data-table" class="table table-hover table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th width="60">序号</th>
                        <th width="140">公司名称</th>
                        <th width="140">系统名称</th>
                        <th width="300">文本框内容</th>
                        <th width="180">顶部图片高度</th>
                        <th width="180">悬浮框宽度</th>
                        <th width="180">悬浮图片</th>
                        <th width="180">轮播图片1</th>
                        <th width="180">轮播图片2</th>
                        <th width="180">轮播图片3</th>
                        <th width="180">轮播图片4</th>
                        <th width="180">轮播图片5</th>
                        <th width="180">推送起始日期</th>
                        <th width="180">推送截止日期</th>
                        <th width="180">创建日期</th>
                        <th width="280">操作</th>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
        `);
        $table = $('#data-table');
    }

    // 渲染表格数据
    renderTable(data);
}

// 你的renderTable函数（稍作修改）
function renderTable(data) {
    var tbody = $('#data-table tbody');
    tbody.empty();

    data.forEach(function(item, index) {
        var row = '<tr>' +
            '<td>' + (index + 1) + '</td>' +
            '<td>' + (item.gsname || '--') + '</td>' +
            '<td>' + (item.xtname || '--') + '</td>' +
            '<td title="' + (item.textbox || '') + '">' +
            (item.textbox ? (item.textbox.length > 50 ? item.textbox.substring(0, 50) + '...' : item.textbox) : '--') +
            '</td>' +
            '<td>' + (item.topgao || '--') + '</td>' +
            '<td>' + (item.xuankuan || '--') + '</td>' +
            '<td>' + (item.tptop1 ? '<img src="data:image/jpg;base64,' + item.tptop1 + '" style="max-width: 80px; max-height: 60px;" />' : '--') + '</td>' +
            '<td>' + (item.tptop2 ? '<img src="data:image/jpg;base64,' + item.tptop2 + '" style="max-width: 80px; max-height: 60px;" />' : '--') + '</td>' +
            '<td>' + (item.tptop3 ? '<img src="data:image/jpg;base64,' + item.tptop3 + '" style="max-width: 80px; max-height: 60px;" />' : '--') + '</td>' +
            '<td>' + (item.tptop4 ? '<img src="data:image/jpg;base64,' + item.tptop4 + '" style="max-width: 80px; max-height: 60px;" />' : '--') + '</td>' +
            '<td>' + (item.tptop5 ? '<img src="data:image/jpg;base64,' + item.tptop5 + '" style="max-width: 80px; max-height: 60px;" />' : '--') + '</td>' +
            '<td>' + (item.tptop6 ? '<img src="data:image/jpg;base64,' + item.tptop6 + '" style="max-width: 80px; max-height: 60px;" />' : '--') + '</td>' +
            '<td>' + (item.qidate ? new Date(item.qidate).toLocaleDateString() : '--') + '</td>' +
            '<td>' + (item.zhidate ? new Date(item.zhidate).toLocaleDateString() : '--') + '</td>' +
            '<td>' + (item.date ? new Date(item.date).toLocaleDateString() : '--') + '</td>' +
            '<td>' +
            '    <button class="btn btn-sm btn-primary edit-btn" data-id="' + item.id + '">' +
            '        <i class="bi bi-pencil-square"></i> 修改' +
            '    </button>' +
            '    <button class="btn btn-sm btn-danger delete-btn" data-id="' + item.id + '" style="margin-left: 5px;">' +
            '        <i class="bi bi-trash"></i> 删除' +
            '    </button>' +
            '</td>' +
            '</tr>';
        tbody.append(row);
    });

    // 添加表格容器样式以支持滚动
    $('.table-div').css({
        'overflow-x': 'auto',
        'width': '100%'
    });
}

// 修改后的getList函数
function getList() {
    $('#query').val('');

    // 显示加载状态
    showLoading();

    $.ajax({
        type: 'GET', // 改为GET请求
        url: '/pushnews/getnews',
        success: function(res) {
            // 隐藏加载状态
            hideLoading();
            setTable(res);
        },
        error: function(xhr, status, error) {
            hideLoading();
            console.error('获取数据失败:', error);
            alert('获取数据失败');
        }
    });
}

// 辅助函数：显示加载状态
function showLoading() {
    // 创建或显示加载指示器
    if ($('#loadingIndicator').length === 0) {
        $('body').append('<div id="loadingIndicator" style="position:fixed;top:50%;left:50%;transform:translate(-50%,-50%);z-index:9999;background:rgba(0,0,0,0.7);color:white;padding:20px;border-radius:5px;">加载中...</div>');
    } else {
        $('#loadingIndicator').show();
    }
}

// 辅助函数：隐藏加载状态
function hideLoading() {
    $('#loadingIndicator').hide();
}

// 页面加载完成后初始化
$(document).ready(function() {
    // 移除或注释掉这行，因为setTable中会创建表格
    // initTableStructure();

    // 获取数据
    getList();

    // 绑定刷新按钮
    $("#refresh-btn").click(function() {
        getList();
    });

    // 绑定编辑表单提交事件（确保在DOM ready后绑定）
    $('#edit-form').on('submit', function(e) {
        e.preventDefault();
        handleEditFormSubmit();
    });
});

// 移除或注释掉这个函数，因为setTable中会创建表格
// function initTableStructure() {
//     var $tableContainer = $('.table-div');
//     if ($tableContainer.find('#newsTable').length === 0) {
//         $tableContainer.html('<table id="newsTable"></table>');
//     }
// }

//点击查询按钮
$(document).ready(function() {
    $('#select-btn').click(function() {
        // 获取并验证输入参数
        var system = $('#system').val();
        var company = $('#company').val().trim();

        // 构建查询参数（自动过滤空值）
        var queryParams = {};
        if(system) queryParams.system = system;
        if(company && company.trim() !== '') queryParams.company = company;

        // 显示加载状态
        showLoading();

        // 发送请求
        $.ajax({
            type: 'POST',
            url: '/pushnews/getlittle',
            data: queryParams,
            success: function(res) {
                hideLoading();
                setTable(res);
            },
            error: function(xhr) {
                hideLoading();
                console.error('请求失败:', xhr.statusText);
            }
        });
    });
});

// 新增功能
$(document).ready(function() {
    // 新增按钮点击事件
    $('#xinzeng-btn').click(function() {
        // 重置表单
        $('#add-form')[0].reset();
        $('#add-modal').modal('show');
    });

    // 新增表单提交处理
    $('#add-form').on('submit', function(e) {
        e.preventDefault();

        // 收集表单数据
        var formData = new FormData(this);
        var formObject = {};

        // 将FormData转换为普通对象
        for (var pair of formData.entries()) {
            // 跳过空文件字段
            if (pair[1] instanceof File && pair[1].size === 0) {
                continue;
            }
            formObject[pair[0]] = pair[1];
        }

        // 确保日期字段是字符串格式（YYYY-MM-DD）
        if (formObject.qidate instanceof Date) {
            formObject.qidate = formObject.qidate.toISOString().split('T')[0];
        }

        if (formObject.zhidate instanceof Date) {
            formObject.zhidate = formObject.zhidate.toISOString().split('T')[0];
        }

        // 处理图片文件上传
        var fileFields = ['tptop1', 'tptop2', 'tptop3', 'tptop4', 'tptop5', 'tptop6'];
        var filePromises = [];

        fileFields.forEach(function(field) {
            var fileInput = $('input[name="' + field + '"]')[0];
            if (fileInput.files.length > 0 && fileInput.files[0].size > 0) {
                var promise = new Promise(function(resolve) {
                    var reader = new FileReader();
                    reader.onload = function(e) {
                        formObject[field] = e.target.result.split(',')[1]; // 获取base64部分
                        resolve();
                    };
                    reader.readAsDataURL(fileInput.files[0]);
                });
                filePromises.push(promise);
            }
        });

        // 等待所有图片转换完成
        Promise.all(filePromises).then(function() {
            // 显示加载状态
            showLoading();

            // 发送新增请求
            $.ajax({
                type: 'POST',
                url: '/pushnews/add',
                contentType: 'application/json',
                data: JSON.stringify(formObject),
                success: function(response) {
                    hideLoading();
                    if (response > 0) {
                        alert('新增成功！');
                        $('#add-modal').modal('hide');
                        getList(); // 刷新表格
                    } else {
                        alert('新增失败');
                    }
                },
                error: function(xhr) {
                    hideLoading();
                    alert('新增失败，请稍后重试');
                    console.error('新增失败:', xhr.statusText);
                }
            });
        });
    });
});

// 修改功能
// 图片预览功能
function previewImage(input, previewId) {
    const preview = document.getElementById(previewId);
    const clearBtn = preview.nextElementSibling;

    if (input.files && input.files[0]) {
        const reader = new FileReader();
        reader.onload = function(e) {
            preview.src = e.target.result;
            preview.style.display = 'block';
            clearBtn.style.display = 'block';
        }
        reader.readAsDataURL(input.files[0]);
    }
}

// 清除图片
function clearImage(inputName, previewId) {
    const input = document.querySelector(`input[name="${inputName}"]`);
    const preview = document.getElementById(previewId);
    const clearBtn = preview.nextElementSibling;

    input.value = '';
    preview.src = '';
    preview.style.display = 'none';
    clearBtn.style.display = 'none';
}

// 编辑按钮点击事件
$(document).on('click', '.edit-btn', function() {
    const id = $(this).data('id');
    console.log('编辑按钮点击，ID:', id);

    if (!id) {
        alert('无法获取数据ID');
        return;
    }

    // 显示加载状态
    showLoading();

    // 获取数据
    $.ajax({
        url: '/pushnews/getById?id=' + id,
        type: 'GET',
        success: function(data) {
            hideLoading();
            console.log('获取数据成功:', data);

            if (data) {
                // 填充表单数据
                fillEditForm(data);
                $('#edit-modal').modal('show');
            } else {
                alert('未找到相关数据');
            }
        },
        error: function(xhr, status, error) {
            hideLoading();
            console.error('获取数据失败:', error);
            alert('获取数据失败: ' + error);
        }
    });
});

// 填充编辑表单
function fillEditForm(data) {
    const form = $('#edit-form');

    // 填充基本字段
    form.find('input[name="id"]').val(data.id);
    form.find('input[name="gsname"]').val(data.gsname);
    form.find('select[name="xtname"]').val(data.xtname);
    form.find('textarea[name="textbox"]').val(data.textbox);
    form.find('input[name="xuankuan"]').val(data.xuankuan);
    form.find('input[name="topgao"]').val(data.topgao);

    // 填充日期字段
    if (data.qidate) {
        form.find('input[name="qidate"]').val(formatDateForInput(data.qidate));
    }
    if (data.zhidate) {
        form.find('input[name="zhidate"]').val(formatDateForInput(data.zhidate));
    }

    // 显示现有图片
    showExistingImages(data);
}

// 显示现有图片
function showExistingImages(data) {
    const imageFields = ['tptop1', 'tptop2', 'tptop3', 'tptop4', 'tptop5', 'tptop6'];

    imageFields.forEach(field => {
        const preview = document.getElementById(`preview-${field}`);
        const clearBtn = preview.nextElementSibling;

        if (data[field]) {
            preview.src = 'data:image/jpeg;base64,' + data[field];
            preview.style.display = 'block';
            clearBtn.style.display = 'block';
        } else {
            preview.style.display = 'none';
            clearBtn.style.display = 'none';
        }
    });
}

// 日期格式转换
function formatDateForInput(dateString) {
    if (!dateString) return '';
    const date = new Date(dateString);
    return date.toISOString().split('T')[0];
}

// 编辑表单提交处理函数
function handleEditFormSubmit() {
    console.log('开始处理编辑表单提交');

    const formData = new FormData(document.getElementById('edit-form'));
    const formObject = {};

    // 首先处理非文件字段
    for (let pair of formData.entries()) {
        // 跳过文件字段，后面单独处理
        if (pair[1] instanceof File) {
            continue;
        }
        formObject[pair[0]] = pair[1];
    }

    // 处理图片文件 - 使用async/await更清晰
    const fileFields = ['tptop1', 'tptop2', 'tptop3', 'tptop4', 'tptop5', 'tptop6'];

    // 使用Promise.all处理所有文件
    const filePromises = fileFields.map(async (field) => {
        const fileInput = document.querySelector(`input[name="${field}"]`);

        // 如果没有选择新文件，保留原有值或设置为null
        if (!fileInput || !fileInput.files || fileInput.files.length === 0) {
            // 检查是否有现有的base64数据（从预览图片获取）
            const preview = document.getElementById(`preview-${field}`);
            if (preview && preview.src && preview.src.startsWith('data:')) {
                // 从预览图片获取base64数据
                const existingBase64 = preview.src.split(',')[1];
                formObject[field] = existingBase64;
            } else {
                // 没有新文件也没有预览，设置为空字符串
                formObject[field] = '';
            }
            return Promise.resolve();
        }

        const file = fileInput.files[0];
        if (file.size === 0) {
            formObject[field] = '';
            return Promise.resolve();
        }

        return new Promise((resolve) => {
            const reader = new FileReader();
            reader.onload = function(e) {
                try {
                    const result = e.target.result;
                    if (typeof result === 'string' && result.startsWith('data:')) {
                        formObject[field] = result.split(',')[1]; // 获取base64部分
                    } else {
                        formObject[field] = '';
                    }
                    console.log(`文件 ${field} 处理完成，类型:`, typeof formObject[field]);
                } catch (error) {
                    console.error(`文件 ${field} 处理错误:`, error);
                    formObject[field] = '';
                }
                resolve();
            };
            reader.onerror = function() {
                console.error(`文件 ${field} 读取失败`);
                formObject[field] = '';
                resolve();
            };
            reader.readAsDataURL(file);
        });
    });

    // 处理日期字段
    if (formObject.qidate) {
        formObject.qidate = new Date(formObject.qidate).toISOString().split('T')[0];
    }
    if (formObject.zhidate) {
        formObject.zhidate = new Date(formObject.zhidate).toISOString().split('T')[0];
    }

    console.log('准备提交的数据:', formObject);

    // 等待所有文件处理完成
    Promise.all(filePromises).then(() => {
        // 再次检查所有字段，确保没有对象类型
        Object.keys(formObject).forEach(key => {
            if (typeof formObject[key] === 'object' && formObject[key] !== null) {
                console.warn(`字段 ${key} 是对象类型，转换为空字符串`);
                formObject[key] = '';
            }
        });

        console.log('最终提交数据:', formObject);
        submitEditData(formObject);
    });
}

// 提交编辑数据
function submitEditData(formObject) {
    showLoading();

    $.ajax({
        type: 'POST',
        url: '/pushnews/update',
        contentType: 'application/json',
        data: JSON.stringify(formObject),
        success: function(response) {
            hideLoading();
            console.log('修改响应:', response);
            if (response > 0) {
                alert('修改成功！');
                $('#edit-modal').modal('hide');
                getList(); // 刷新列表
            } else {
                alert('修改失败');
            }
        },
        error: function(xhr, status, error) {
            hideLoading();
            console.error('修改失败详情:', {
                status: xhr.status,
                statusText: xhr.statusText,
                responseText: xhr.responseText
            });
            alert('修改失败，请稍后重试');
        }
    });
}

// 删除功能 - 修复为正确的POST请求
$(document).on('click', '.delete-btn', function() {
    const id = $(this).data('id');
    console.log('删除按钮点击，ID:', id);

    if (!id) {
        alert('无法获取数据ID');
        return;
    }

    if (confirm('确定要删除这条记录吗？')) {
        showLoading();

        // 使用POST请求和JSON格式
        $.ajax({
            type: 'GET',
            url: '/pushnews/delete?id='+id,
            success: function() {
                hideLoading();
                    getList(); // 刷新表格
                alert('删除成功！');
            },
            error: function(xhr, status, error) {
                hideLoading();
                console.error('删除失败详情:', {
                    status: xhr.status,
                    statusText: xhr.statusText,
                    responseText: xhr.responseText
                });
                alert('删除失败，请稍后重试');
            }
        });
    }
});

// 取消按钮事件
$(document).ready(function() {
    // 新增模态框取消按钮
    $('#add-modal .btn-secondary').click(function() {
        $('#add-modal').modal('hide');
    });

    // 编辑模态框取消按钮
    $('#edit-modal .btn-secondary').click(function() {
        $('#edit-modal').modal('hide');
    });

    // 修改确认按钮为手动触发
    $('#edit-modal .btn-primary').click(function(e) {
        e.preventDefault();
        handleEditFormSubmit();
    });
});