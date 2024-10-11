import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { LucideIcon } from "lucide-react"

type StatCardProps = {
  title: string
  value: string
  icon: LucideIcon
  change: string
}

export function StatCard({ title, value, icon: Icon, change }: StatCardProps) {
  return (
    <Card>
      <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
        <CardTitle className="text-sm font-medium text-gray-600">{title}</CardTitle>
        <Icon className="h-4 w-4 text-gray-600" />
      </CardHeader>
      <CardContent>
        <div className="text-2xl font-bold text-black">{value}</div>
        <p className="text-xs text-gray-600">{change}</p>
      </CardContent>
    </Card>
  )
}
