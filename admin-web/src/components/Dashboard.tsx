import React from 'react';
import {Card, Col, Row, Space, Statistic, Typography} from 'antd';
import {DashboardOutlined, SettingOutlined, TeamOutlined, UserOutlined} from '@ant-design/icons';

const {Title} = Typography;

const Dashboard: React.FC = () => {
    return (
        <Space direction="vertical" size="large" style={{width: '100%'}}>
            <div className="page-header">
                <Title level={2} style={{margin: 0}}>
                    <DashboardOutlined style={{marginRight: 8}}/>
                    控制台
                </Title>
            </div>

            <Row gutter={[16, 16]}>
                <Col xs={24} sm={12} lg={6}>
                    <Card>
                        <Statistic
                            title="总用户数"
                            value={1234}
                            prefix={<UserOutlined/>}
                            valueStyle={{color: '#3f8600'}}
                        />
                    </Card>
                </Col>

                <Col xs={24} sm={12} lg={6}>
                    <Card>
                        <Statistic
                            title="角色数量"
                            value={12}
                            prefix={<TeamOutlined/>}
                            valueStyle={{color: '#cf1322'}}
                        />
                    </Card>
                </Col>

                <Col xs={24} sm={12} lg={6}>
                    <Card>
                        <Statistic
                            title="在线用户"
                            value={93}
                            prefix={<UserOutlined/>}
                            valueStyle={{color: '#1890ff'}}
                        />
                    </Card>
                </Col>

                <Col xs={24} sm={12} lg={6}>
                    <Card>
                        <Statistic
                            title="系统状态"
                            value="正常"
                            prefix={<SettingOutlined/>}
                            valueStyle={{color: '#52c41a'}}
                        />
                    </Card>
                </Col>
            </Row>

            <Row gutter={[16, 16]}>
                <Col xs={24} lg={12}>
                    <Card title="快速操作" className="content-card">
                        <Space direction="vertical" style={{width: '100%'}}>
                            <p>• 用户管理：管理系统用户账户</p>
                            <p>• 角色管理：配置用户角色权限</p>
                            <p>• 系统设置：调整系统配置参数</p>
                        </Space>
                    </Card>
                </Col>

                <Col xs={24} lg={12}>
                    <Card title="系统信息" className="content-card">
                        <Space direction="vertical" style={{width: '100%'}}>
                            <p>版本：v1.0.0</p>
                            <p>最后更新：2024-01-15</p>
                            <p>服务器：运行正常</p>
                            <p>数据库：连接正常</p>
                        </Space>
                    </Card>
                </Col>
            </Row>
        </Space>
    );
};

export default Dashboard;