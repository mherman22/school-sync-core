import { StatCard } from '@/components/Overview/StatCard'
import { Users, BookOpen, Calendar } from "lucide-react"

export default function OverviewPage() {
  return (
    <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-4">
      <StatCard title="Total Students" value="1,234" icon={Users} change="+20 from last month" />
      <StatCard title="Total Teachers" value="56" icon={Users} change="+2 from last month" />
      <StatCard title="Classes" value="24" icon={BookOpen} change="+1 from last month" />
      <StatCard title="Upcoming Events" value="3" icon={Calendar} change="Next: Parent-Teacher Meeting" />
    </div>
  )
}