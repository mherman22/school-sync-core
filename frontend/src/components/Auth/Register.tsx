import React, { useState } from 'react';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from '@/components/ui/card';

type UserRole =
  | 'student'
  | 'teacher'
  | 'admin'
  | 'finance'
  | 'health'
  | 'dormitory';

type RegisterProps = {
  onRegister: (
    name: string,
    email: string,
    password: string,
    role: UserRole
  ) => void;
};

export function Register({ onRegister }: RegisterProps) {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [role, setRole] = useState<UserRole>('student');

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onRegister(name, email, password, role);
  };

  return (
    <Card className="w-[350px] bg-white">
      <CardHeader>
        <CardTitle className="text-black">Register</CardTitle>
        <CardDescription className="text-gray-600">
          Create a new account to access the system.
        </CardDescription>
      </CardHeader>
      <CardContent>
        <form onSubmit={handleSubmit}>
          <div className="grid w-full items-center gap-4">
            <div className="flex flex-col space-y-1.5">
              <Input
                id="name"
                placeholder="Full Name"
                value={name}
                onChange={(e) => setName(e.target.value)}
                required
                className="bg-white text-black border-gray-300"
              />
            </div>
            <div className="flex flex-col space-y-1.5">
              <Input
                id="email"
                placeholder="Email"
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
                className="bg-white text-black border-gray-300"
              />
            </div>
            <div className="flex flex-col space-y-1.5">
              <Input
                id="password"
                placeholder="Password"
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
                className="bg-white text-black border-gray-300"
              />
            </div>
            <div className="flex flex-col space-y-1.5">
              <select
                value={role}
                onChange={(e) => setRole(e.target.value as UserRole)}
                className="flex h-10 w-full rounded-md border border-gray-300 bg-white px-3 py-2 text-sm text-black focus:outline-none focus:ring-2 focus:ring-gray-400 focus:border-transparent"
              >
                <option value="student">Student</option>
                <option value="teacher">Teacher</option>
                <option value="admin">Administrator</option>
                <option value="finance">Finance</option>
                <option value="health">Health</option>
                <option value="dormitory">Dormitory</option>
              </select>
            </div>
          </div>
        </form>
      </CardContent>
      <CardFooter className="flex justify-between">
        <Button variant="outline" className="text-black border-gray-300">
          Cancel
        </Button>
        <Button
          type="submit"
          onClick={handleSubmit}
          className="bg-blue-600 text-white hover:bg-blue-700"
        >
          Register
        </Button>
      </CardFooter>
    </Card>
  );
}
