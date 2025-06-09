import React from 'react';
import {Button, Form, Input, Space, Typography} from 'antd';
import {LockOutlined, LoginOutlined, UserOutlined} from '@ant-design/icons';

const {Title} = Typography;

interface LoginPageProps {
    onLogin: () => void;
}

const LoginPage: React.FC<LoginPageProps> = ({onLogin}) => {
    const [form] = Form.useForm();

    const handleSubmit = (values: any) => {
        console.log('登录信息:', values);
        // 这里可以添加实际的登录验证逻辑
        // 暂时模拟登录成功
        onLogin();
    };

    return (
        <div className="login-container">
            <div className="login-form">
                <Space direction="vertical" size="large" style={{width: '100%'}}>
                    <Title level={2} className="login-title">
                        系统登录
                    </Title>

                    <Form
                        form={form}
                        name="login"
                        onFinish={handleSubmit}
                        autoComplete="off"
                        size="large"
                    >
                        <Form.Item
                            name="username"
                            rules={[
                                {required: true, message: '请输入用户名!'},
                                {min: 3, message: '用户名至少3个字符!'}
                            ]}
                        >
                            <Input
                                prefix={<UserOutlined/>}
                                placeholder="用户名"
                            />
                        </Form.Item>

                        <Form.Item
                            name="password"
                            rules={[
                                {required: true, message: '请输入密码!'},
                                {min: 6, message: '密码至少6个字符!'}
                            ]}
                        >
                            <Input.Password
                                prefix={<LockOutlined/>}
                                placeholder="密码"
                            />
                        </Form.Item>

                        <Form.Item>
                            <Button
                                type="primary"
                                htmlType="submit"
                                icon={<LoginOutlined/>}
                                style={{width: '100%'}}
                            >
                                登录
                            </Button>
                        </Form.Item>
                    </Form>

                    <div style={{textAlign: 'center', color: '#666', fontSize: '14px'}}>
                        <p>演示账号：admin / 123456</p>
                    </div>
                </Space>
            </div>
        </div>
    );
};

export default LoginPage;