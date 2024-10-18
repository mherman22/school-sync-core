'use client';

import { useRouter } from 'next/navigation';
import { Register } from '@/components/Auth/Register';

export default function RegisterPage() {
  const router = useRouter();

  const handleRegister = (
    name: string,
    email: string,
    password: string,
    role: string
  ) => {
    // Implement registration logic here
    console.log('Registration attempt:', name, email, password, role);
    // After successful registration, redirect to login page
    router.push('/login');
  };

  return (
    <div className="flex h-screen items-center justify-center bg-gray-100">
      <Register onRegister={handleRegister} />
    </div>
  );
}
