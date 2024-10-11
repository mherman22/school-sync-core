'use client';

import { useRouter, usePathname } from 'next/navigation'
import { Button } from "@/components/ui/button"
import { BookOpen, Calendar, FileText, Users, Printer, DollarSign, Activity, Home } from "lucide-react"

export function Sidebar() {
  const router = useRouter()
  const pathname = usePathname()

  const navItems = [
    { href: '/dashboard', icon: BookOpen, label: 'Overview' },
    { href: '/dashboard/reports', icon: FileText, label: 'Reports' },
    { href: '/dashboard/timetables', icon: Calendar, label: 'Timetables' },
    { href: '/dashboard/teachers', icon: Users, label: 'Teachers' },
    { href: '/dashboard/circular', icon: Printer, label: 'Print Circular' },
    { href: '/dashboard/finance', icon: DollarSign, label: 'Finance' },
    { href: '/dashboard/dispensary', icon: Activity, label: 'Dispensary' },
    { href: '/dashboard/dormitory', icon: Home, label: 'Dormitory' },
  ]

  return (
    <div className="w-64 bg-white p-6 shadow-md">
      <h2 className="text-2xl font-bold mb-6 text-black">MGMS</h2>
      <nav>
        {navItems.map((item) => (
          <Button
            key={item.href}
            variant="ghost"
            className={`w-full justify-start mb-2 ${
              pathname === item.href ? 'bg-gray-200 text-black' : 'text-gray-700 hover:text-black'
            }`}
            onClick={() => router.push(item.href)}
          >
            <item.icon className="mr-2 h-4 w-4" />
            {item.label}
          </Button>
        ))}
      </nav>
    </div>
  )
}
