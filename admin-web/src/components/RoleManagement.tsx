import React, {useState} from 'react';
import type {TreeDataNode} from 'antd';
import {
    Button,
    Card,
    Divider,
    Form,
    Input,
    message,
    Modal,
    Popconfirm,
    Space,
    Table,
    Tag,
    Tree,
    Typography
} from 'antd';
import {DeleteOutlined, EditOutlined, KeyOutlined, PlusOutlined, TeamOutlined} from '@ant-design/icons';
import type {ColumnsType} from 'antd/es/table';

const {Title} = Typography;
const {TextArea} = Input;

interface Role {
    id: string;
    name: string;
    description: string;
    permissions: string[];
    userCount: number;
    createTime: string;
}

const RoleManagement: React.FC = () => {
    const [roles, setRoles] = useState<Role[]>([
        {
            id: '1',
            name: '超级管理员',
            description: '拥有系统所有权限',
            permissions: ['user:read', 'user:write', 'role:read', 'role:write', 'system:read', 'system:write'],
            userCount: 1,
            createTime: '2024-01-01',
        },
        {
            id: '2',
            name: '管理员',
            description: '拥有用户管理权限',
            permissions: ['user:read', 'user:write', 'role:read'],
            userCount: 3,
            createTime: '2024-01-02',
        },
        {
            id: '3',
            name: '普通用户',
            description: '基础用户权限',
            permissions: ['user:read'],
            userCount: 56,
            createTime: '2024-01-03',
        },
    ]);

    const [isModalVisible, setIsModalVisible] = useState(false);
    const [editingRole, setEditingRole] = useState<Role | null>(null);
    const [form] = Form.useForm();
    const [checkedKeys, setCheckedKeys] = useState<React.Key[]>([]);

    // 权限树结构
    const permissionTree: TreeDataNode[] = [
        {
            title: '用户管理',
            key: 'user',
            children: [
                {
                    title: '查看用户',
                    key: 'user:read',
                },
                {
                    title: '编辑用户',
                    key: 'user:write',
                },
            ],
        },
        {
            title: '角色管理',
            key: 'role',
            children: [
                {
                    title: '查看角色',
                    key: 'role:read',
                },
                {
                    title: '编辑角色',
                    key: 'role:write',
                },
            ],
        },
        {
            title: '系统管理',
            key: 'system',
            children: [
                {
                    title: '查看系统',
                    key: 'system:read',
                },
                {
                    title: '系统设置',
                    key: 'system:write',
                },
            ],
        },
    ];

    const columns: ColumnsType<Role> = [
        {
            title: '角色名称',
            dataIndex: 'name',
            key: 'name',
            render: (name: string) => (
                <Space>
                    <TeamOutlined/>
                    <span>{name}</span>
                </Space>
            ),
        },
        {
            title: '描述',
            dataIndex: 'description',
            key: 'description',
        },
        {
            title: '权限数量',
            dataIndex: 'permissions',
            key: 'permissions',
            render: (permissions: string[]) => (
                <Tag color="blue">{permissions.length} 个权限</Tag>
            ),
        },
        {
            title: '用户数量',
            dataIndex: 'userCount',
            key: 'userCount',
            render: (count: number) => (
                <Tag color="green">{count} 个用户</Tag>
            ),
        },
        {
            title: '创建时间',
            dataIndex: 'createTime',
            key: 'createTime',
        },
        {
            title: '操作',
            key: 'action',
            render: (_, record) => (
                <Space size="middle">
                    <Button
                        type="link"
                        icon={<EditOutlined/>}
                        onClick={() => handleEdit(record)}
                    >
                        编辑
                    </Button>
                    <Popconfirm
                        title="确定要删除这个角色吗？"
                        onConfirm={() => handleDelete(record.id)}
                        okText="确定"
                        cancelText="取消"
                        disabled={record.name === '超级管理员'}
                    >
                        <Button
                            type="link"
                            danger
                            icon={<DeleteOutlined/>}
                            disabled={record.name === '超级管理员'}
                        >
                            删除
                        </Button>
                    </Popconfirm>
                </Space>
            ),
        },
    ];

    const handleAdd = () => {
        setEditingRole(null);
        form.resetFields();
        setCheckedKeys([]);
        setIsModalVisible(true);
    };

    const handleEdit = (role: Role) => {
        setEditingRole(role);
        form.setFieldsValue({
            name: role.name,
            description: role.description,
        });
        setCheckedKeys(role.permissions);
        setIsModalVisible(true);
    };

    const handleDelete = (id: string) => {
        setRoles(roles.filter(role => role.id !== id));
        message.success('角色删除成功');
    };

    const handleModalOk = () => {
        form.validateFields().then((values) => {
            const permissions = checkedKeys.filter(key =>
                typeof key === 'string' && key.includes(':')
            ) as string[];

            if (editingRole) {
                // 编辑角色
                setRoles(roles.map(role =>
                    role.id === editingRole.id
                        ? {...role, ...values, permissions}
                        : role
                ));
                message.success('角色更新成功');
            } else {
                // 添加新角色
                const newRole: Role = {
                    id: Date.now().toString(),
                    ...values,
                    permissions,
                    userCount: 0,
                    createTime: new Date().toISOString().split('T')[0],
                };
                setRoles([...roles, newRole]);
                message.success('角色添加成功');
            }
            setIsModalVisible(false);
            form.resetFields();
            setCheckedKeys([]);
        });
    };

    const handleModalCancel = () => {
        setIsModalVisible(false);
        form.resetFields();
        setCheckedKeys([]);
    };

    const onCheck = (checkedKeysValue: React.Key[]) => {
        setCheckedKeys(checkedKeysValue);
    };

    return (
        <Space direction="vertical" size="large" style={{width: '100%'}}>
            <div className="page-header">
                <div style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center'}}>
                    <Title level={2} style={{margin: 0}}>
                        <TeamOutlined style={{marginRight: 8}}/>
                        角色管理
                    </Title>
                    <Button
                        type="primary"
                        icon={<PlusOutlined/>}
                        onClick={handleAdd}
                    >
                        添加角色
                    </Button>
                </div>
            </div>

            <Card className="content-card">
                <Table
                    columns={columns}
                    dataSource={roles}
                    rowKey="id"
                    pagination={{
                        pageSize: 10,
                        showSizeChanger: true,
                        showQuickJumper: true,
                        showTotal: (total) => `共 ${total} 条记录`,
                    }}
                />
            </Card>

            <Modal
                title={editingRole ? '编辑角色' : '添加角色'}
                open={isModalVisible}
                onOk={handleModalOk}
                onCancel={handleModalCancel}
                okText="确定"
                cancelText="取消"
                width={600}
            >
                <Form
                    form={form}
                    layout="vertical"
                    name="roleForm"
                >
                    <Form.Item
                        name="name"
                        label="角色名称"
                        rules={[
                            {required: true, message: '请输入角色名称!'},
                            {min: 2, message: '角色名称至少2个字符!'}
                        ]}
                    >
                        <Input placeholder="请输入角色名称"/>
                    </Form.Item>

                    <Form.Item
                        name="description"
                        label="角色描述"
                        rules={[{required: true, message: '请输入角色描述!'}]}
                    >
                        <TextArea
                            placeholder="请输入角色描述"
                            rows={3}
                        />
                    </Form.Item>

                    <Divider/>

                    <div>
                        <Space style={{marginBottom: 16}}>
                            <KeyOutlined/>
                            <span style={{fontWeight: 500}}>权限配置</span>
                        </Space>
                        <Tree
                            checkable
                            checkedKeys={checkedKeys}
                            onCheck={onCheck}
                            treeData={permissionTree}
                            style={{background: '#fafafa', padding: 16, borderRadius: 6}}
                        />
                    </div>
                </Form>
            </Modal>
        </Space>
    );
};

export default RoleManagement;