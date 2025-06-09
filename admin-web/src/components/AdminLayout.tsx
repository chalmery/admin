import React, {useState} from 'react';
import type {MenuProps} from 'antd';
import {Avatar, Dropdown, Layout, Menu, Space, Typography} from 'antd';
import {
    DashboardOutlined,
    LogoutOutlined,
    MenuFoldOutlined,
    MenuUnfoldOutlined,
    SettingOutlined,
    UserOutlined
} from '@ant-design/icons';
import {Route, Routes, useLocation, useNavigate} from 'react-router-dom';
import {Shield} from 'lucide-react';
import RoleManagement from './RoleManagement';
import UserManagement from './UserManagement';
import Dashboard from './Dashboard';

const {Header, Sider, Content} = Layout;
const {Text} = Typography;

interface AdminLayoutProps {
    onLogout: () => void;
}

const AdminLayout: React.FC<AdminLayoutProps> = ({onLogout}) => {
    const [collapsed, setCollapsed] = useState(false);
    const navigate = useNavigate();
    const location = useLocation();

    // 菜单项配置
    const menuItems: MenuProps['items'] = [
        {
            key: '/admin',
            icon: <DashboardOutlined/>,
            label: '控制台',
        },
        {
            key: 'user-management',
            icon: <UserOutlined/>,
            label: '用户管理',
            children: [
                {
                    key: '/admin/users',
                    label: '用户列表',
                },
                {
                    key: '/admin/roles',
                    label: '角色管理',
                },
            ],
        },
        {
            key: 'system-management',
            icon: <SettingOutlined/>,
            label: '系统管理',
            children: [
                {
                    key: '/admin/settings',
                    label: '系统设置',
                },
            ],
        },
    ];

    // 用户下拉菜单
    const userMenuItems: MenuProps['items'] = [
        {
            key: 'profile',
            icon: <UserOutlined/>,
            label: '个人中心',
        },
        {
            key: 'settings',
            icon: <SettingOutlined/>,
            label: '账户设置',
        },
        {
            type: 'divider',
        },
        {
            key: 'logout',
            icon: <LogoutOutlined/>,
            label: '退出登录',
            onClick: onLogout,
        },
    ];

    const handleMenuClick = ({key}: { key: string }) => {
        if (key.startsWith('/admin')) {
            navigate(key);
        }
    };

    // 获取当前选中的菜单key
    const getSelectedKeys = () => {
        const path = location.pathname;
        if (path === '/admin' || path === '/admin/') {
            return ['/admin'];
        }
        return [path];
    };

    return (
        <Layout className="admin-layout">
            <Sider
                trigger={null}
                collapsible
                collapsed={collapsed}
                className="admin-sidebar"
                width={240}
                collapsedWidth={80}
            >
                <div style={{padding: '16px', textAlign: 'center'}}>
                    <div className="logo-section" style={{justifyContent: 'center'}}>
                        <div className="logo-icon">
                            <Shield size={18}/>
                        </div>
                        {!collapsed && <Text className="logo-text">管理系统</Text>}
                    </div>
                </div>

                <Menu
                    theme="dark"
                    mode="inline"
                    selectedKeys={getSelectedKeys()}
                    items={menuItems}
                    onClick={handleMenuClick}
                />
            </Sider>

            <Layout>
                <Header className="admin-header">
                    <div className="logo-section">
                        <div
                            style={{cursor: 'pointer'}}
                            onClick={() => setCollapsed(!collapsed)}
                        >
                            {collapsed ? <MenuUnfoldOutlined/> : <MenuFoldOutlined/>}
                        </div>
                    </div>

                    <div className="user-section">
                        <Dropdown
                            menu={{items: userMenuItems}}
                            placement="bottomRight"
                            trigger={['click']}
                        >
                            <Space style={{cursor: 'pointer'}}>
                                <Avatar
                                    size="small"
                                    icon={<UserOutlined/>}
                                    style={{backgroundColor: '#1890ff'}}
                                />
                                <Text>管理员</Text>
                            </Space>
                        </Dropdown>
                    </div>
                </Header>

                <Content className="admin-content">
                    <Routes>
                        <Route path="/" element={<Dashboard/>}/>
                        <Route path="/users" element={<UserManagement/>}/>
                        <Route path="/roles" element={<RoleManagement/>}/>
                        <Route path="/settings" element={<div className="content-card">系统设置功能开发中...</div>}/>
                    </Routes>
                </Content>
            </Layout>
        </Layout>
    );
};

export default AdminLayout;