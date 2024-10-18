import { Bell } from 'lucide-react';
import { Button } from '@/components/ui/button';

export function Header() {
  return (
    <header className="bg-white shadow-md p-4">
      <div className="flex justify-between items-center">
        <h1 className="text-2xl font-bold text-black">
          School Sync Management System
        </h1>
        <Button
          variant="outline"
          className="bg-white text-black hover:bg-gray-100"
        >
          <Bell className="mr-2 h-4 w-4 text-black" />
          Notifications
        </Button>
      </div>
    </header>
  );
}
