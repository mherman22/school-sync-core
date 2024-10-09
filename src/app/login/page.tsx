'use client';

import { useRouter } from 'next/navigation';
import { Login } from '@/components/Auth/Login';

export default function LoginPage() {
  const router = useRouter();

  const handleLogin = (email: string, password: string, role: string) => {
    // Implement login logic here
    console.log('Login attempt:', email, password, role);
    // After successful login, redirect to dashboard
    router.push('/dashboard');
  };

  return (
    <div className="flex h-screen items-center justify-center bg-gray-100">
      <Login onLogin={handleLogin} />
    </div>
  );
}