import React, {useState} from 'react';
import {Button, Card, Form, Input, message, Modal, Popconfirm, Select, Space, Table, Tag, Typography} from 'antd';
import {DeleteOutlined, EditOutlined, PlusOutlined, UserOutlined} from '@ant-design/icons';
import type {ColumnsType} from 'antd/es/table';

const {Title} = Typography;
const {Option} = Select;

interface User {
    id: string;
    username: string;
    email: string;
    role: string;
    status: 'active' | 'inactive';
    createTime: string;
}

const UserManagement: React.FC = () => {
    const [users, setUsers] = useState<User[]>([
        {
            id: '1',
            username: 'admin',
            email: 'admin@example.com',
            role: '超级管理员',
            status: 'active',
            createTime: '2024-01-01',
        },
        {
            id: '2',
            username: 'user1',
            email: 'user1@example.com',
            role: '普通用户',
            status: 'active',
            createTime: '2024-01-02',
        },
        {
            id: '3',
            username: 'user2',
            email: 'user2@example.com',
            role: '普通用户',
            status: 'inactive',
            createTime: '2024-01-03',
        },
    ]);

    const [isModalVisible, setIsModalVisible] = useState(false);
    const [editingUser, setEditingUser] = useState<User | null>(null);
    const [form] = Form.useForm();

    const columns: ColumnsType<User> = [
        {
            title: '用户名',
            dataIndex: 'username',
            key: 'username',
        },
        {
            title: '邮箱',
            dataIndex: 'email',
            key: 'email',
        },
        {
            title: '角色',
            dataIndex: 'role',
            key: 'role',
            render: (role: string) => (
                <Tag color={role === '超级管理员' ? 'red' : 'blue'}>{role}</Tag>
            ),
        },
        {
            title: '状态',
            dataIndex: 'status',
            key: 'status',
            render: (status: string) => (
                <Tag color={status === 'active' ? 'green' : 'orange'}>
                    {status === 'active' ? '激活' : '禁用'}
                </Tag>
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
                        title="确定要删除这个用户吗？"
                        onConfirm={() => handleDelete(record.id)}
                        okText="确定"
                        cancelText="取消"
                    >
                        <Button
                            type="link"
                            danger
                            icon={<DeleteOutlined/>}
                        >
                            删除
                        </Button>
                    </Popconfirm>
                </Space>
            ),
        },
    ];

    const handleAdd = () => {
        setEditingUser(null);
        form.resetFields();
        setIsModalVisible(true);
    };

    const handleEdit = (user: User) => {
        setEditingUser(user);
        form.setFieldsValue(user);
        setIsModalVisible(true);
    };

    const handleDelete = (id: string) => {
        setUsers(users.filter(user => user.id !== id));
        message.success('用户删除成功');
    };

    const handleModalOk = () => {
        form.validateFields().then((values) => {
            if (editingUser) {
                // 编辑用户
                setUsers(users.map(user =>
                    user.id === editingUser.id
                        ? {...user, ...values}
                        : user
                ));
                message.success('用户更新成功');
            } else {
                // 添加新用户
                const newUser: User = {
                    id: Date.now().toString(),
                    ...values,
                    createTime: new Date().toISOString().split('T')[0],
                };
                setUsers([...users, newUser]);
                message.success('用户添加成功');
            }
            setIsModalVisible(false);
            form.resetFields();
        });
    };

    const handleModalCancel = () => {
        setIsModalVisible(false);
        form.resetFields();
    };

    return (
        <Space direction="vertical" size="large" style={{width: '100%'}}>
            <div className="page-header">
                <div style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center'}}>
                    <Title level={2} style={{margin: 0}}>
                        <UserOutlined style={{marginRight: 8}}/>
                        用户管理
                    </Title>
                    <Button
                        type="primary"
                        icon={<PlusOutlined/>}
                        onClick={handleAdd}
                    >
                        添加用户
                    </Button>
                </div>
            </div>

            <Card className="content-card">
                <Table
                    columns={columns}
                    dataSource={users}
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
                title={editingUser ? '编辑用户' : '添加用户'}
                open={isModalVisible}
                onOk={handleModalOk}
                onCancel={handleModalCancel}
                okText="确定"
                cancelText="取消"
            >
                <Form
                    form={form}
                    layout="vertical"
                    name="userForm"
                >
                    <Form.Item
                        name="username"
                        label="用户名"
                        rules={[
                            {required: true, message: '请输入用户名!'},
                            {min: 3, message: '用户名至少3个字符!'}
                        ]}
                    >
                        <Input placeholder="请输入用户名"/>
                    </Form.Item>

                    <Form.Item
                        name="email"
                        label="邮箱"
                        rules={[
                            {required: true, message: '请输入邮箱!'},
                            {type: 'email', message: '请输入有效的邮箱地址!'}
                        ]}
                    >
                        <Input placeholder="请输入邮箱"/>
                    </Form.Item>

                    <Form.Item
                        name="role"
                        label="角色"
                        rules={[{required: true, message: '请选择角色!'}]}
                    >
                        <Select placeholder="请选择角色">
                            <Option value="超级管理员">超级管理员</Option>
                            <Option value="管理员">管理员</Option>
                            <Option value="普通用户">普通用户</Option>
                        </Select>
                    </Form.Item>

                    <Form.Item
                        name="status"
                        label="状态"
                        rules={[{required: true, message: '请选择状态!'}]}
                    >
                        <Select placeholder="请选择状态">
                            <Option value="active">激活</Option>
                            <Option value="inactive">禁用</Option>
                        </Select>
                    </Form.Item>
                </Form>
            </Modal>
        </Space>
    );
};

export default UserManagement;