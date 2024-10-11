import { StatCard } from '@/components/Overview/StatCard'
import { Users, BookOpen, Calendar } from "lucide-react"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"

// Mock data for charts (you'd replace this with real data from your backend)
const dispensaryVisits = [
  { month: 'Jan', visits: 45 },
  { month: 'Feb', visits: 52 },
  { month: 'Mar', visits: 49 },
  { month: 'Apr', visits: 62 },
  { month: 'May', visits: 55 },
  { month: 'Jun', visits: 61 },
]

const tuitionPayments = [
  { status: 'Paid', count: 850 },
  { status: 'Partial', count: 320 },
  { status: 'Unpaid', count: 64 },
]

export default function OverviewPage() {
  return (
    <div className="space-y-6">
      <h1 className="text-3xl font-bold text-black">Overview</h1>
      
      <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-4">
        <StatCard title="Total Students" value="1,234" icon={Users} change="+20 from last month" />
        <StatCard title="Total Teachers" value="56" icon={Users} change="+2 from last month" />
        <StatCard title="Classes" value="24" icon={BookOpen} change="+1 from last month" />
        <StatCard title="Upcoming Events" value="3" icon={Calendar} change="Next: Parent-Teacher Meeting" />
      </div>

      <div className="grid gap-4 md:grid-cols-2">
        <Card>
          <CardHeader>
            <CardTitle className="text-xl text-black">Dispensary Visits (Last 6 Months)</CardTitle>
          </CardHeader>
          <CardContent>
            <div className="h-[200px] w-full">
              {/* Replace this with an actual chart component */}
              <div className="flex h-full items-end justify-between">
                {dispensaryVisits.map((data, index) => (
                  <div key={index} className="flex flex-col items-center">
                    <div 
                      className="bg-blue-500 w-8" 
                      style={{height: `${(data.visits / 62) * 100}%`}}
                    ></div>
                    <span className="text-xs mt-1">{data.month}</span>
                  </div>
                ))}
              </div>
            </div>
          </CardContent>
        </Card>

        <Card>
          <CardHeader>
            <CardTitle className="text-xl text-black">Tuition Payment Status</CardTitle>
          </CardHeader>
          <CardContent>
            <div className="h-[200px] w-full">
              {/* Replace this with an actual chart component */}
              <div className="flex h-full items-center justify-around">
                {tuitionPayments.map((data, index) => (
                  <div key={index} className="flex flex-col items-center">
                    <div className="text-2xl font-bold">{data.count}</div>
                    <div className="text-sm text-gray-500">{data.status}</div>
                  </div>
                ))}
              </div>
            </div>
          </CardContent>
        </Card>
      </div>

      <Card>
        <CardHeader>
          <CardTitle className="text-xl text-black">Recent Dispensary Visits</CardTitle>
        </CardHeader>
        <CardContent>
          <div className="space-y-4">
            {[
              { name: "Alice Johnson", reason: "Headache", date: "2023-06-15" },
              { name: "Bob Smith", reason: "Fever", date: "2023-06-14" },
              { name: "Carol Williams", reason: "Sprained ankle", date: "2023-06-13" },
            ].map((visit, index) => (
              <div key={index} className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
                <span className="text-black font-medium">{visit.name}</span>
                <span className="text-gray-600">{visit.reason}</span>
                <span className="text-gray-600">{visit.date}</span>
              </div>
            ))}
          </div>
        </CardContent>
      </Card>
    </div>
  )
}
